/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.app.endpoint;

import com.py.projectstructure.app.action.AbstractAction;
import com.py.projectstructure.app.action.ActionContext;
import com.py.projectstructure.app.action.Actions;
import com.py.projectstructure.lib.validation.CLTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author aledesma
 */
public class AbstractEndpoint {

	// ::: constants
	//
	private static final Logger logger = Logger.getLogger(AbstractEndpoint.class.getName());

	// ::: vars
	//

	@Autowired
	protected ApplicationContext appContext;

	// ::: HANDLE
	//
	protected <A extends AbstractAction, T> ResponseEntity handle(Class<A> actionClass, T arg) {
		try {
			var action = Actions.perform(actionClass, actionContext(), arg);
			return responseOk(action.getResult());

		} catch (Throwable t) {
			return responseError(t);
		}
	}

	protected ActionContext actionContext() {
		var context = Actions.newContext(appContext);

		return context;
	}

	protected <T> ResponseEntity responseOk(T body) {
		return ResponseEntity.ok(body);
	}

	protected <T> ResponseEntity responseError(Throwable t) {
		if (t == null) {
			t = new NullPointerException("unassigned error");
		}

		Map error = new HashMap();
		if (t instanceof CLTException ex) {
			error.put("code", ex.getCode());
			error.put("name", ex.getName());
			error.put("extra", ex.getExtra());
			error.put("text", ex.getMessage());
		} else {
			logger.log(Level.WARNING, "unexpected exception", t);

			error.put("code", 1);
			error.put("name", "unknwonw");
			error.put("extra", null); //
			error.put("text", t.getMessage());
		}

		// error body
		Map body = new HashMap();
		body.put("failure", error);
		body.put("status", error.get("code"));

		return responseError(500, body);
	}

	protected <T> ResponseEntity responseError(int httpStatus, T body) {
		return ResponseEntity.status(httpStatus).body(body);
	}
}
