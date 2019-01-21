	/*-------------------------多选--------------------------- */

		function duo(){
			var str1="";
			var suiji="";
			var random="";
			$.ajax({
				url:'http://localhost:8080/jeesite-demo/a/multiple/multipleSelection/getmultiple',
				type:'post',
				async:false,
				success:function(data){
			for(var i=1;i<=2;i++){
				
				str1+='<li id="qu_1_'+i+'">'+
				'<div class="test_content_nr_tt">'+
					'<i>'+i+'</i><span>(10分)</span>'+
					'<h3 style="" id="duotop'+i+'">'+data[i-1]["title"]+'</h3><b class="icon iconfont">&#xe881;</b>'+
				'</div>'+
				'<div class="test_content_nr_main">'+
					'<ul>'+
						'<li class="option">'+
							'<input type="checkbox" class="radioOrCheck" name="muanswer'+i+'" id="1_answer_'+i+'_option_1" value="A"/>'+
								'<label for="1_answer_'+i+'_option_1">'+
								'A.'+
							'<p class="ue" style="display: inline;">'+data[i-1]["a"]+'</p>'+
								'</label>'+
						'</li>'+
					
					'<li class="option">'+
						
						'<input type="checkbox" class="radioOrCheck" name="muanswer'+i+'" id="1_answer_'+i+'_option_2" value="B"/>'+
						
						'<label for="1_answer_'+i+'_option_2">'+
	                			'B.'+
	                			'<p class="ue" style="display: inline;">'+data[i-1]["b"]+'</p>'+
						'</label>'+
					'</li>'+
					'<li class="option">'+
						'<input type="checkbox" class="radioOrCheck" name="muanswer'+i+'" id="1_answer_'+i+'_option_3" value="C"/>'+
						'<label for="1_answer_'+i+'_option_3">'+
					    'C.'+
						'<p class="ue" style="display: inline;">'+data[i-1]["c"]+'</p>'+
						'</label>'+
					'</li>'+
					'<li class="option">'+
						'<input type="checkbox" class="radioOrCheck" name="muanswer'+i+'" id="1_answer_'+i+'_option_4" value="D"/>'+
						'<label for="1_answer_'+i+'_option_4">'+
	        					'D.'+
	        					'<p class="ue" style="display: inline;">'+data[i-1]["d"]+'</p>'+
						'</label>'+
					'</li>'+
					'</ul>'+
					'<font class="duoresult'+i+'"></font>'+
				'</div>'+
			'</li>';
				duoans[i]=data[i-1]["answer"];
	}
		
			
		$(".duoxuan").html(str1);
				}
			});
		}
		
		
		
		