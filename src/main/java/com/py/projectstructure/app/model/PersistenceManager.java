/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.app.model;


import com.py.projectstructure.app.action.ActionContext;
import com.py.projectstructure.mod.ztest.model.ZtestPersistence;

/**
 * @author aledesma
 */
public class PersistenceManager {

	// ::: vars
	//
	private ActionContext ac;

	// ::: constructors
	//
	public PersistenceManager(ActionContext ac) {
		this.ac = ac;
	}

	// ::: api
	//

	public ZtestPersistence getZtestPersistence(){
		return new ZtestPersistence(ac);
	}


}
