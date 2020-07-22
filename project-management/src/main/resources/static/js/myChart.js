// For a pie chart

console.log("js file is loaded");
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
        data: {
        labels: ['January', 'February', 'March'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#00BFFF","#7B68EE", "#0000CD" ],
            borderColor: 'rgb(255, 255, 255)',
            data: [10, 5, 2]
        }]
    },

    // Configuration options go here
    options: {}
});
