	function daan(){
		clearInterval(timeId);
		$(".alt-1").html('00:00:00')
		var value='';
		var dandaan="";
		var duodaan="";
		var mid='0';
		var duoselect=[]
//			-------单选-------
		for (var j=1;j<=5;j++) {
		var dansum=0;
		var radio = document.getElementsByName("answer"+j);
		mid=dandaan;
			for(var i = 0;i<radio.length;i++)
		{
			if(radio[i].checked==true)
			{
			dandaan+= radio[i].value;
			if(dandaan[i]==danans[i])
				{dansum=6;
				}
			}	
		}
		if(dandaan=='')
		{value+=" ";}

		if(dansum!=6)
		{
			document.getElementById("dantop"+j).style.color="red";
		}
		dangrade+=dansum;
}		
//		-------------------单选结果------------------
		
		for(var i=1;i<=5;i++){
			if(dandaan[i-'1']==undefined){
				$(".result"+i).html('你的选择：'+'<br>'+'正确答案：'+danans[i-'1']);
			}else{
				$(".result"+i).html('你的选择：'+dandaan[i-'1']+'<br>'+'正确答案：'+danans[i-'1']);
			}
			
			
		}
//		-------------------多选----------

	 for(var j=1;j<=2;j++){
		var poi="";
	 	var test1 = document.getElementsByName("muanswer"+j);
	 	duodaan="";
	 	poi=duoans[j];	 	
	 	var duosum=10;
	 	var flag=0;
	    for(var i=0; i < test1.length; i++) {
		if(test1[i].checked) {
			
			duodaan+= test1[i].value;
			
		}
		
		}
	 	
	 	duoselect[j]=duodaan;
	 	console.log(duoselect[j])
	    for(var i=0;i<duodaan.length;i++){
	    if(poi.indexOf(duodaan[i])==-1){
				duosum=0;
				
			}
		}
	    if(duodaan=='')
	    {duosum=0;}
	    if(duosum!=0){
	 	for(var i=0;i<poi.length;i++){
		if(duodaan.indexOf(poi[i])==-1)
				duosum=5;
				
	 	}}
	    if(duosum!=10)
	    {document.getElementById("duotop"+j).style.color="red";}
	 	duograde+=duosum;
	 
	}
	/*----------------------多选结果-----------------------------*/
	
		for(var i=1;i<=2;i++){
			if(duoselect[i]==undefined){
				$(".duoresult"+i).html('你的选择：'+'<br>'+'正确答案：'+duoans[i]);
			}else{
				console.log(duoselect[i+'1'])
				$(".duoresult"+i).html('你的选择：'+duoselect[i]+'<br>'+'正确答案：'+duoans[i]);
			}
		}
	finalgrade=dangrade+duograde;
	openWindow();
	$("#f1").attr('style','display:none');
	}