/**
 * 
 */

function fn_ok() {
	var name = document.getElementsByName('name')[0].value;
	var id = document.getElementsByName('id')[0].value;
	var pwd = document.getElementsByName('pwd')[0].value;
	var email = document.getElementsByName('email')[0].value;
	var date = document.getElementsByName('date')[0].value;
	var female = document.getElementByName('gender')[0].value;
	var male = document.getElementByName('gender')[1].value;
	
	if(name == null || name ==''){
		alert('이름을 입력해주세요.');
	}else if(id == null || id ==''){
		alert('아이디를 입력해주세요,');
	}else if(pwd == null || pwd ==''){
		alert('암호를 입력해주세요,');
	}else if(email == null || email ==''){
		alert('이메일을 입력해주세요,');
	}else if(date == null || date ==''){
		alert('생일을 입력해주세요,');
	}else if(female == null && male == null){
		alert('성별을 입력해주세요,');
	}else{
		frm.action = 'loginServ';
		frm.method = 'post';
		frm.submit;
	}
}