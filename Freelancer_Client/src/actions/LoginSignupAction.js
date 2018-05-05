var axios = require('axios');


const headers = {
    'Accept': 'application/json'
};

export function loginAction(email, password) {

	return  function(dispatch){
		console.log("Calling some api")

	  fetch('http://localhost:8080/user/login', {
		method: 'POST',
		headers: {
			...headers,
			'Content-Type': 'application/json'
		},
		credentials:'include',
		body: JSON.stringify({	email : email , 
	  							password : password  })
		}).then(function (response) {
			if(response.status === 200){
				response.json().then(res => {
			 	
				 	var payload = {'islogin':true, 'currentUser': res.id} ;
				 	dispatch({type : 'login' , payload });
				 	console.log(res);
				 })	
			}else{
				console.log("Login Failed");	
			}
			
			 
		})
		.catch(error => {
			console.log("Error hai bhai " , error)
			 dispatch({type : 'login' , payload : {'islogin':false}})
		})
	}
}

export function signupAction(username,password,email,usertype) {
/*
	return  function(dispatch){
		console.log("Calling signup api")
		 axios.post('http://localhost:8080/user/signup', {
		  	password : password , 
		  	username : username,
		  	usertype : usertype , 
		  	email : email 
	  })
	  .then(function (response) {
	  	console.log('Response ' , response ) ; 
		dispatch({type : 'signup' , payload : true});
	  }).catch((err) => dispatch({type : 'signup' , payload : false}))
	}

*/

	return  function(dispatch){
		console.log("Calling some api")

	  fetch('http://localhost:8080/user/signup', {
		method: 'POST',
		headers: {
			...headers,
			'Content-Type': 'application/json'
		},
		credentials:'include',
		body: JSON.stringify({	
			password : password , 
		  	username : username,
		  	usertype : usertype , 
		  	email : email   })
		}).then(function (response) {
			 response.json().then(res => {
			 	/*console.log("Polash " , res.result);
			 	var payload = {'islogin':true, 'currentUser': res.result[0].ID} ;
			 	dispatch({type : 'login' , payload });*/
			 	dispatch({type : 'signup' , payload : true});
			 	console.log(res);
			 })
			 console.log(response);
		})
		.catch(error => {
			 dispatch({type : 'signup' , payload : false})
		})
	}


}

