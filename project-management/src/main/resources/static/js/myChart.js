var chartDataStr = decodeHtml(chartData);
var JsObjectArr = JSON.parse(chartDataStr);

var valueArr = [];
var labelArr = [];

for(let i = 0; i < JsObjectArr.length; i++){
	labelArr[i] = JsObjectArr[i].label;
	valueArr[i] = JsObjectArr[i].value;
}

//For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
        data: {
        //labels: ['January', 'February', 'March'],
        labels: labelArr,	
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#00BFFF","#7B68EE", "#0000CD" ],
            borderColor: 'rgb(255, 255, 255)',
           // data: [10, 5, 2]
            data: valueArr
        
        }]
    },

    // Configuration options go here
    options: {
    	title:{
    		display:true,
    		text:'Project Status'
    	}
    }
});

// "[{"value" : 1, "label": "COMPLETED"}, {"value" : 2, "label": "INPROGRESS"}, {"value" : 1, "label": "NOTSTARTED"}]"
function decodeHtml(data){
	var txt = document.createElement("textarea");
	txt.innerHTML = data;
	return txt.value;
}