package com.py.projectstructure.mod.ztest.endpoint;

import com.py.projectstructure.app.endpoint.AbstractEndpoint;
import com.py.projectstructure.mod.ztest.action.ZtestAction;
import com.py.projectstructure.mod.ztest.action.ZtestArgument;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/project")
public class ZtestEndpoint extends AbstractEndpoint {


  // ::: endpoints
  //

  @GetMapping("/ztest")
  public ResponseEntity findAll(@ModelAttribute ZtestArgument arg){
    return handle(ZtestAction.class, arg);
  }


}
