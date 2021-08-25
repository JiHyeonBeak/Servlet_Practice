function fnlogin() {
		var id = frm.user_id.value;
		var pwd = frm.user_pwd.value;
		
		if(id == null || id ==""){
			alert("아이디를 입력해주세요.");
			frm.user_id.focus();
		}else if(pwd == null || pwd == ""){
			alert("암호를 입력해주세요.");
			frm.user_pwd.focus();
		}else{
			frm.submit();
		}
	}
	
function fnmember(){
		var id = frm.join_id.value;
		var pwd = frm.join_pwd.value;
		var name = frm.join_name.value;
		var email = frm.join_email.value;
		
		if(id == null || id ==""){
			alert("아이디를 입력해주세요.");
			frm.user_id.focus();
		}else if(pwd == null || pwd == ""){
			alert("암호를 입력해주세요.");
			frm.user_pwd.focus();
		}else if(name == null || name == ""){
			alert("이름을 입력해주세요.");
			frm.join_name.focus();
		}else if(email == null || email == ""){
			alert("이메일을 입력해주세요.");
			frm.join_email.focus();
		}
		else{
			frm.submit();
		}
	}