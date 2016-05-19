package controller;

import handler.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tatiana.biliaieva on 5/10/2016.
 */
@RestController
@RequestMapping(value = "/message")
public class MessageConroller {
  private static final Logger logger = LoggerFactory
      .getLogger(MessageConroller.class);

  @Autowired
  private EventService eventService;

  @RequestMapping(value = {"/send"}, method = {RequestMethod.GET})
  public ResponseEntity<String> send(@RequestParam("message") String message) throws Exception {

    eventService.publishEvent(message);

    return new ResponseEntity(message, HttpStatus.OK);
  }
}
