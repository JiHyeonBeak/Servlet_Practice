	var txt = ['여','기','는',' ','메','아','리','창','고','.','.','.'];
	var i = 0;

	function oncl() {
		pp.submit();
	}
	
	setInterval(function typing(){
		
			if(i<=11){
			var num = txt[i];
			document.getElementById('stress').append(num);
			i++;
		}else{
			i = 0;
			document.getElementById('stress').innerText='     ';
		}
	}, 350);
	
	