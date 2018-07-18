var code ; 
function createCode(){  
     code = "";   
     var codeLength = 4;//  
     var checkCode = document.getElementById("code");   
     var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
     'S','T','U','V','W','X','Y','Z');//
     for(var i = 0; i < codeLength; i++) {// 
        var index = Math.floor(Math.random()*36);//
        code += random[index];// 
    }  
    checkCode.value = code;//
}  
window.onload = createCode();

function validate(){  
    var inputCode = document.getElementById("input").value.toUpperCase(); //
    if(inputCode.length <= 0) { //
        alert("请输入验证码"); //
    }         
    else if(inputCode != code ) { //
        alert("验证码错误"); //
        createCode();// 
        document.getElementById("input").value = "";//
		return false; 
    }         
    else { //
        alert("ok"); //
		return true;  
    }   
	         
} 
