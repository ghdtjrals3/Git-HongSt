package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QrCodeController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "qrCode/qrCodeForm")
	public String qrCodeForm() { 
		log.info(this.getClass().getName() + ".qrCodeForm start !");
		
		return "qrCode/QrCodeMaker";
	}


}
