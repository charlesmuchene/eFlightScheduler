var globe_index = 0;
var myVar;

function test() {
    
    var $sechdule = $('#sechdules');
    var $card = $('.card');

    $.ajax({
                        type: "GET",
                        url: 'http://localhost:8080/eflight/api/schedule/' +globe_index,
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (data) {
                            
                            if (data.length > 0)  {
                                globe_index = data[data.length - 1].id;
                                $sechdule.empty();
                            }       
                            console.log("success", globe_index);
                            var col_max_value = 4;

                            for(i = 0 ; i < data.length ; i++){

                                if(i > col_max_value){
                        
                                    break;
                                }

                                $sechdule.append('<div class="card">'
                        +'<h3 class="title">' + "Flight No"+ data[i].flight.id + '</h3>'+
                        '<div class="bar">' +
                            '<div class="emptybar"></div>'+
                           '<div class="filledbar"></div>' +
                        '</div>' +
                        '<div class="info_body">'+

                           '<div class = "breaker_">' +
                                '<div class="icon_div">'+
                                    '<span><i class="fa fa-plane"></i></span>'+
                                '</div>'+
                                '<div class="text_div">'+
                                    '<span>'+ data[i].flight.airline +'</span><br>'+
                                '</div>'+
                            '</div>'+

                            '<div class = "breaker_">'+
                                '<div class="icon_div">'+
                                    '<span><i class="fa fa-building"></i></span>'+
                                '</div>'+
                                '<div class="text_div">'+
                                    '<span> Iwoa, USA</span><br>'+
                                '</div>'+
                            '</div>' +

                            '<div class = "breaker_">' +
                                '<div class="icon_div">' +
                                    '<span><i class="fa fa-road"></i></span>' +
                                '</div>' +
                                '<div class="text_div">'+
                                    '<span>'+ data[i].runway.code +'</span><br>'+
                                '</div>'+
                           '</div>'+

                            '<div class = "breaker_">'+
                                '<div class="icon_div">'+
                                    '<span><i class="fa fa-clock-o"></i></span>'+
                                '</div>'+
                                '<div class="text_div">'+
                                    '<span>' +  moment(data[i].time).endOf('day').fromNow()  + '</span><br>' +
                                '</div>'+
                            '</div>'+

                           '<div class = "breaker_">'+
                                '<div class="icon_div">'+
                                    '<span><i class="fa fa-flag"></i></span>'+
                                '</div>'+
                                '<div class="text_div">'+
                                    '<span>' + data[i].status + '</span><br>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                '</div>'      
                               );
                               
                            }
                                     
                        }
                    }); 
  
}


$(document).ready(function(){
      // test();
       setInterval("test()", 5000);
    });

