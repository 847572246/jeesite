	/* --------------------------单选------------------------------	 */	
function dan(){
	/*var type=(location.href).split('?')[1];*/
		var str="";
		var suiji="";
		var random="";
		$.ajax({
			url:'http://localhost:8080/jeesite-demo/a/single/singleSelection/getsingle',
			type:'post',
			async:false,
			success:function(data){
				/*console.log(data);*/
				for(var i=1;i<=5;i++){
				str+='<li id="qu_0_'+i+'">'+
				'<div class="test_content_nr_tt">'+
					'<i>'+i+'</i><span>(5分)</span>'+
			'<h3 id="dantop'+i+'">'+data[i-1]["title"]+'</h3>'+
			'<b class="icon iconfont">&#xe881;</b>'+
			'</div>'+
			'<div class="test_content_nr_main">'+
			'<ul>'+
			'<li class="option">'+
			'<input type="radio" class="radioOrCheck" name="answer'+i+'" id="0_answer_'+i+'_option_1" value="A"/>'+
			'<label for="0_answer_'+i+'_option_1">'+
			      ' A.'+
			       '<p class="ue" style="display: inline;">'+data[i-1]["a"]+'</p>'+
			'</label>'+
			'</li>'+
			'<li class="option">'+
				'<input type="radio" class="radioOrCheck" name="answer'+i+'" id="0_answer_'+i+'_option_2" value="B"/>'+
				'<label for="0_answer_'+i+'_option_2">'	+
					'B.'+
					'<p class="ue" style="display: inline;">'+data[i-1]["b"]+'</p>'+
				'</label>'+
			'</li>'+
			'<li class="option">'+
				'<input type="radio" class="radioOrCheck" name="answer'+i+'" id="0_answer_'+i+'_option_3" value="C"/>'+
				'<label for="0_answer_'+i+'_option_3">'+
					'C.'+
					'<p class="ue" style="display: inline;">'+data[i-1]["c"]+'</p>'+
				'</label>'+
			'</li>'+
			'<li class="option">'+
				'<input type="radio" class="radioOrCheck" name="answer'+i+'" id="0_answer_'+i+'_option_4" value="D"/>'+
				'<label for="0_answer_'+i+'_option_4">'+
					'D.'+
					'<p class="ue" style="display: inline;">'+data[i-1]["d"]+'</p>'+
				'</label>'+
			'</li>'+
			'</ul>'+
			
			'<font class="result'+i+'"></font>'+
			'</div>'+
			'</li>';
				danans+=data[i-1]["answer"];
							}
			

			$(".danxuan").html(str);
			flag=-1;
				
			}
			
			});
		}