package test;


import java.util.ArrayList;
import java.util.Calendar;
public class freelancerTest {
	
	
	
	@Autowired
    private WebApplicationContext wac;

	
	@Bean
	public static RestTemplate restTemplate(){
		return new RestTemplate();
	}
	

    @Test
    public void getActivity() {
    	String params = "amano";
        ResponseEntity<freelancer_useractivity[]> res = restTemplate().postForEntity("http://localhost:8082/api/getActivity", params, dropbox_useractivity[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void setFiles() {
    	String params = "amano";
        ResponseEntity<dropbox_userfiles[]> res = restTemplate().postForEntity("http://localhost:8082/api/setFiles", params, dropbox_userfiles[].class);

        assertEquals(200, res.getStatusCodeValue());
    }


