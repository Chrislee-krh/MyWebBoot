package org.zerock.myweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myweb.command.Criteria;
import org.zerock.myweb.command.ReplyVO;
import org.zerock.myweb.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/replies/")
@RestController
@Log4j2
@AllArgsConstructor
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	//댓글 생성..
	 @PostMapping(value = "/new",
	         consumes = "application/json", //json으로 body에서 받겠다.(json으로 전달해야한다는 뜻)
	         produces = {MediaType.TEXT_PLAIN_VALUE}) //응답 타입은 text/plain
	 public ResponseEntity<String> create(@RequestBody ReplyVO vo){ //ReplyVO 타입으로 받는다.
	      
      log.info("ReplyVO: "+vo);
      int insertCount = service.register(vo);
      log.info("Reply INSERT COUNT : " + insertCount);
      return insertCount == 1 ? 
            new ResponseEntity<String>("success", HttpStatus.OK) //200
            : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
   }

	 @GetMapping(value = "/pages/{bno}/{page}", 
		      produces = {
		         MediaType.APPLICATION_JSON_VALUE})
	 public ResponseEntity<List<ReplyVO>> getList(
	     @PathVariable("page") int page,
	     @PathVariable("bno") int bno) 
	 {
		 log.info("getList..........");
		 Criteria cri = new Criteria(page, 10);
		 log.info(cri);
		 return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
     }

	 @GetMapping(value = "/{rno}", 
		      produces = {
		         MediaType.APPLICATION_JSON_VALUE})
	 public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno){
		      
	      log.info("get: "+rno);
	      return new ResponseEntity<ReplyVO>(service.get(rno),HttpStatus.OK);
	 }
	   
	 @DeleteMapping(value = "/{rno}", 
		      produces = {MediaType.TEXT_PLAIN_VALUE})
	   public ResponseEntity<String> remove(@PathVariable("rno") int rno){
	      log.info("remove: "+rno);
	      return service.remove(rno)==1
	         ? new ResponseEntity<String>("success",HttpStatus.OK)
	         :new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
     }
	 
	 @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
	         value = "/{rno}",
	         consumes = "application/json",
	         produces = {MediaType.TEXT_PLAIN_VALUE})
	   public ResponseEntity<String> modify(
	         @RequestBody ReplyVO vo, //json형태로 
	         @PathVariable("rno") int rno){
	      
	      vo.setRno(rno);
	      log.info("rno: "+rno);
	      log.info("modify: "+vo);
	      return service.modify(vo)==1
	         ? new ResponseEntity<>("success",HttpStatus.OK)
	         : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      
	   }


}
