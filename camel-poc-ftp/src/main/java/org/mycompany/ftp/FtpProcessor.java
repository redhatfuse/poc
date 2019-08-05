package org.mycompany.ftp;

import org.apache.camel.builder.RouteBuilder;

public class FtpProcessor extends RouteBuilder  {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("ftp:192.168.43.100:21/input?moveFailed=/error/${date:now:yyyyMMdd}/output.xml&recursive=false&username=fuseuser1&password=password")
		.log("message ${body}")
		.choice()
			.when(xpath("//to = 'f'"))
				.log("EXCEPTION CAUGHT")
		.end()
		.to("ftp:192.168.43.100:21/output?username=fuseuser2&password=password1");				
	}

	
}
