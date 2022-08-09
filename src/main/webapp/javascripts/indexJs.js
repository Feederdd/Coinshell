$(function() {
    $("#tabs").tabs();
});
//jquery控制分頁的功能

//$(function() {
//    upCoin();
//})

// $(function(){
//     某個方法();
// })
// 讓程式一開始就執行某個方法
//這邊設定成這樣，讓整個Dom載入完成後執行upCoin();


var contextRoot = "http://localhost:8080/coinshell"

var day = new Date();
let month = day.getMonth() + 1
month = (month < 10 ? '0' : '') + month
var today = day.getFullYear() + "-" + month + "-" + day.getDate();
//這邊定義今天的日期，格式為yyyy-MM-dd (2022-05-20)




function upCoin(memId) {
    var url = "http://localhost:8080/coinshell/coin/getCoin"
    $.ajax({
        url: url,
        contentType: 'application/json; charset=UTF-8', //送過去的
        dataType: 'json', //傳回來的
        method: 'get',
        success: function(result) {
            $('#top tr td').remove();
            console.log(result)
            $.each(result, function(index, value) {
                coinList = '';
                coinList += '<tr>'
                coinList += '<td>' + value.cmcRank + '</td>'

                if (value.flag == 'Y') {
                    coinList += '<td><label><input type="checkbox" class="check" checked id="' + value.id + '" value="' + value.id + '" onClick="watch(this)"><span class="star"><i  class="fa-solid fa-star"></i></span></label></td>'
                } else {
                    coinList += '<td><label><input type="checkbox" class="check" id="' + value.id + '" value="' + value.id + '" onClick="watch(this)"><span class="star"><i  class="fa-solid fa-star"></i></span></label></td>'
                }

                if (value.setH == '1' || value.setL == '1') {
                    coinList += '<td><label><input type="checkbox" class="checkbell" checked id="bell' + value.id + '" value="' + value.id + '" onClick="set(this)"><span class="bell"><i class="fa-solid fa-bell"></i></span></label></td>'
                } else {
                    coinList += '<td><label><input type="checkbox" class="checkbell" id="bell' + value.id + '" value="' + value.id + '" onClick="set(this)"><span class="bell"><i class="fa-solid fa-bell"></i></span></label></td>'
                }

                coinList += '<td><img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + value.symbol + '.png" alt=""><a href="http://localhost:8080/coinshell/individualCryptocurrencyInformation?currencyName=' + value.symbol + '&currentlyDay=' + value.lastUpdated.substr(0, 10) + '">' + value.name + '</a></td>'
                coinList += '<td>' + value.symbol + '</td>'
                coinList += '<td class="price">' + value.price + '</td>'
                coinList += '<td class="1h">' + value.percentChange1h + '</td>'
                coinList += '<td class="24h">' + value.percentChange24h + '</td>'
                coinList += '<td class="7d">' + value.percentChange7d + '</td>'
                coinList += '<td class="30d">' + value.percentChange30d + '</td>'
                coinList += '<td class="vol24h">' + value.volume24h + '</td>'
                coinList += '<td class="market">' + value.marketCap + '</td>'
                coinList += '<td style="width:10px;height:10px"><canvas id="myChart' + value.cmcRank + '"></canvas></td>'
                coinList += '</tr>';

                $('#top').append(coinList);

                var value1 = result[0].percentChange1h
                var value2 = result[1].percentChange1h
                var value3 = result[2].percentChange1h
                var value4 = result[3].percentChange1h
                var value5 = result[4].percentChange1h
                var value6 = result[5].percentChange1h
                var value7 = result[6].percentChange1h
                var value8 = result[7].percentChange1h
                var value9 = result[8].percentChange1h
                var value10 = result[9].percentChange1h

                if (value1 < 0) {
                    $('#mar1').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[0].symbol + '.png" alt="">' + result[0].name + ' $<td><font color="red">' + result[0].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar1').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[0].symbol + '.png" alt="">' + result[0].name + ' $<td><font color="green">' + result[0].price.toFixed(2)) + '</font><td>';
                };

                if (value2 < 0) {
                    $('#mar2').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[1].symbol + '.png" alt="">' + result[1].name + ' $<td><font color="red">' + result[1].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar2').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[1].symbol + '.png" alt="">' + result[1].name + ' $<td><font color="green">' + result[1].price.toFixed(2)) + '</font><td>';
                };

                if (value3 < 0) {
                    $('#mar3').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[2].symbol + '.png" alt="">' + result[2].name + ' $<td><font color="red">' + result[2].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar3').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[2].symbol + '.png" alt="">' + result[2].name + ' $<td><font color="green">' + result[2].price.toFixed(2)) + '</font><td>';
                };

                if (value4 < 0) {
                    $('#mar4').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[3].symbol + '.png" alt="">' + result[3].name + ' $<td><font color="red">' + result[3].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar4').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[3].symbol + '.png" alt="">' + result[3].name + ' $<td><font color="green">' + result[3].price.toFixed(2)) + '</font><td>';
                };

                if (value5 < 0) {
                    $('#mar5').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[4].symbol + '.png" alt="">' + result[4].name + ' $<td><font color="red">' + result[4].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar5').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[4].symbol + '.png" alt="">' + result[4].name + ' $<td><font color="green">' + result[4].price.toFixed(2)) + '</font><td>';
                };

                if (value6 < 0) {
                    $('#mar6').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[5].symbol + '.png" alt="">' + result[5].name + ' $<td><font color="red">' + result[5].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar6').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[5].symbol + '.png" alt="">' + result[5].name + ' $<td><font color="green">' + result[5].price.toFixed(2)) + '</font><td>';
                };

                if (value7 < 0) {
                    $('#mar7').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[6].symbol + '.png" alt="">' + result[6].name + ' $<td><font color="red">' + result[6].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar7').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[6].symbol + '.png" alt="">' + result[6].name + ' $<td><font color="green">' + result[6].price.toFixed(2)) + '</font><td>';
                };

                if (value8 < 0) {
                    $('#mar8').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[7].symbol + '.png" alt="">' + result[7].name + ' $<td><font color="red">' + result[7].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar8').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[7].symbol + '.png" alt="">' + result[7].name + ' $<td><font color="green">' + result[7].price.toFixed(2)) + '</font><td>';
                };

                if (value9 < 0) {
                    $('#mar9').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[8].symbol + '.png" alt="">' + result[8].name + ' $<td><font color="red">' + result[8].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar9').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[8].symbol + '.png" alt="">' + result[8].name + ' $<td><font color="green">' + result[8].price.toFixed(2)) + '</font><td>';
                };

                if (value10 < 0) {
                    $('#mar10').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[9].symbol + '.png" alt="">' + result[9].name + ' $<td><font color="red">' + result[9].price.toFixed(2)) + '</font><td>';
                } else {
                    $('#mar10').html('<img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + result[9].symbol + '.png" alt="">' + result[9].name + ' $<td><font color="green">' + result[9].price.toFixed(2)) + '</font><td>';
                };


                //注入折線圖至id=canvas
                var xmlHttp = new XMLHttpRequest();
                var url = "http://localhost:8080/coinshell/historical/get7daysUsdPrice?currencyName=" + value.symbol;
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                xmlHttp.onreadystatechange = function() {
                    // alert(value.id);
                    console.log(value.id)
                    if (this.readyState == 4 && this.status == 200) {
                        var data = JSON.parse(this.responseText);
                        var days = data.map(function(elem) {
                            return elem.informationDate.substr(4, 12).replace('T', '').replace('-', '').replace('-', '').replace(':', '');
                        });
                        var price = data.map(function(elem) {
                            return elem.USD_Price_of_Cryptocurrency;
                        });

                        const ctx = document.getElementById('myChart' + value.cmcRank).getContext('2d');

                        const myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: days,
                                pointHitRadius: 0,
                                datasets: [{
                                    label: 'US',
                                    data: price,
                                    backgroundColor: [
                                        'transparent'
                                    ],
                                    borderColor: 'green',
                                    borderWidth: 3,
                                    lineTension: 0,
                                }]
                            },
                            options: {
                                plugins: {},
                                elements: {
                                    line: {
                                        lineTension: 0
                                    },
                                    point: {
                                        radius: 0
                                    }
                                },
                                scales: {

                                    xAxes: [{
                                        ticks: {
                                            display: false
                                        },
                                        type: 'time',
                                        time: {
                                            unit: 'hour',
                                        },
                                        ticks: {
                                            display: false //this will remove only the label
                                        }
                                    }],
                                    yAxes: {
                                        beginAtZero: false
                                    }
                                },
                                animation: {
                                    duration: 0
                                }

                            }
                        });
                    }
                }

            })
            setUpCoin();
            upjquery();
        },
        error: function(err) {
            console.log(err)
        }
    })
}

//var timeoutID;
//
//function setUpCoin(){
//timeoutID  = window.setTimeout(function(){upCoin()},30000);
//}


function followList() {
    $.ajax({
        url: 'http://localhost:8080/coinshell/coin/getCoin',
        contentType: 'application/json; charset=UTF-8', //送過去的
        dataType: 'json', //傳回來的
        method: 'get',
        success: function(result) {
            $('#watch tr td').remove();
            //		$('#portfolio tr td').remove();
            console.log(result)
            $.each(result, function(index, value) {
                coinList = '';
                if (value.flag == 'Y') {
                    coinList += '<tr>'
                    coinList += '<td>' + value.cmcRank + '</td>'

                    coinList += '<td><label><input type="checkbox" class="check" checked id="' + value.id + '" value="' + value.id + '" onClick="watch(this)"><span class="star"><i  class="fa-solid fa-star"></i></span></label></td>'

                    if (value.setH == '1' || value.setL == '1') {
                        coinList += '<td><label><input type="checkbox" class="checkbell" checked id="bell' + value.id + '" value="' + value.id + '" onClick="set(this)"><span class="bell"><i class="fa-solid fa-bell"></i></span></label></td>'
                    } else {
                        coinList += '<td><label><input type="checkbox" class="checkbell" id="bell' + value.id + '" value="' + value.id + '" onClick="set(this)"><span class="bell"><i class="fa-solid fa-bell"></i></span></label></td>'
                    }

                    coinList += '<td><img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + value.symbol + '.png" alt=""><a href="http://localhost:8080/coinshell/individualCryptocurrencyInformation?currencyName=' + value.symbol + '&currentlyDay=' + value.lastUpdated.substr(0, 10) + '">' + value.name + '</a></td>'
                    coinList += '<td>' + value.symbol + '</td>'
                    coinList += '<td class="price">' + value.price + '</td>'
                    coinList += '<td class="1h">' + value.percentChange1h + '</td>'
                    coinList += '<td class="24h">' + value.percentChange24h + '</td>'
                    coinList += '<td class="7d">' + value.percentChange7d + '</td>'
                    coinList += '<td class="30d">' + value.percentChange30d + '</td>'
                    coinList += '<td class="vol24h">' + value.volume24h + '</td>'
                    coinList += '<td class="market">' + value.marketCap + '</td>'
//                    coinList += '<td style="width:10px;height:10px"><canvas id="myChart' + value.cmcRank + '"></canvas></td>'
                    coinList += '</tr>';

                    $('#watch').append(coinList);

                    //注入折線圖至id=canvas
                    var xmlHttp = new XMLHttpRequest();
                    var url = "http://localhost:8080/coinshell/historical/get30days?currencyName=" + value.symbol;
                    xmlHttp.open("GET", url, true);
                    xmlHttp.send();
                    xmlHttp.onreadystatechange = function() {
                        // alert(value.id);
                        // console.log(value.id)
                        if (this.readyState == 4 && this.status == 200) {
                            var data = JSON.parse(this.responseText);
                            var days = data.map(function(elem) {
                                return elem.informationDate.substr(0, 14).replace('T', '').replace('-', '').replace('-', '').replace(':', '');
                            });
                            var price = data.map(function(elem) {
                                return elem.USD_Price_of_Cryptocurrency;
                            });

                            // const canvasTest = document.getElementById('canvasTest');
                            // const ctx = canvasTest.getContext('2d');
                            const ctx = document.getElementById('myChart' + value.cmcRank).getContext('2d');

                            const myChart = new Chart(ctx, {
                                type: 'line',
                                data: {
                                    labels: days,
                                    pointHitRadius: 0,
                                    datasets: [{
                                        label: 'US',
                                        data: price,
                                        backgroundColor: [
                                            'transparent'
                                        ],
                                        borderColor: 'green',
                                        borderWidth: 3,
                                        lineTension: 0,
                                    }]
                                },
                                options: {
                                    plugins: {},
                                    elements: {
                                        line: {
                                            lineTension: 0
                                        },
                                        point: {
                                            radius: 0
                                        }
                                    },
                                    scales: {
                                        xAxes: [{
                                            type: 'time',
                                            time: {
                                                unit: 'hour',
                                            },

                                        }],
                                        yAxes: {
                                            beginAtZero: false
                                        }
                                    },
                                    animation: {
                                        duration: 0
                                    }

                                }
                            });
                        }
                    }
                }

            })
            window.clearTimeout(timeoutID);
            window.setTimeout(function() { followList() }, 60000);
            upjquery();
        },
        error: function(err) {
            console.log(err)
        }
    })
}
//     window.clearTimeout(timeoutID);
//		 	window.setTimeout(function(){followList()},10000);
//            upjquery();                   


function loadCoinByName(memId) {
    var coinName = document.getElementById("coinName").value;
    $.ajax({
        url: 'http://localhost:8080/coinshell/coin/select?name=' + coinName,
        contentType: 'application/json; charset=UTF-8', //送過去的
        dataType: 'json', //傳回來的
        method: 'get',
        success: function(result) {
            $('#top tr td').remove();
            console.log(result)
            $.each(result, function(index, value) {
                coinList = '';
                coinList += '<tr>'
                coinList += '<td>' + value.cmcRank + '</td>'

                if (value.flag == 'Y') {
                    coinList += '<td><label><input type="checkbox" class="check" checked id="' + value.id + '" value="' + value.id + '" onClick="watch(this)"><span class="star"><i  class="fa-solid fa-star"></i></span></label></td>'
                } else {
                    coinList += '<td><label><input type="checkbox" class="check" id="' + value.id + '" value="' + value.id + '" onClick="watch(this)"><span class="star"><i  class="fa-solid fa-star"></i></span></label></td>'
                }

                if (value.setH == '1' || value.setL == '1') {
                    coinList += '<td><label><input type="checkbox" class="checkbell" checked id="bell' + value.id + '" value="' + value.id + '" onClick="set(this)"><span class="bell"><i class="fa-solid fa-bell"></i></span></label></td>'
                } else {
                    coinList += '<td><label><input type="checkbox" class="checkbell" id="bell' + value.id + '" value="' + value.id + '" onClick="set(this)"><span class="bell"><i class="fa-solid fa-bell"></i></span></label></td>'
                }

                coinList += '<td><img class=currencyIcon src="' + contextRoot + '/images/currencyIcon/' + value.symbol + '.png" alt=""><a href="http://localhost:8080/coinshell/individualCryptocurrencyInformation?currencyName=' + value.symbol + '&currentlyDay=' + value.lastUpdated.substr(0, 10) + '">' + value.name + '</a></td>'
                coinList += '<td>' + value.symbol + '</td>'
                coinList += '<td class="price">' + value.price + '</td>'
                coinList += '<td class="1h">' + value.percentChange1h + '</td>'
                coinList += '<td class="24h">' + value.percentChange24h + '</td>'
                coinList += '<td class="7d">' + value.percentChange7d + '</td>'
                coinList += '<td class="30d">' + value.percentChange30d + '</td>'
                coinList += '<td class="vol24h">' + value.volume24h + '</td>'
                coinList += '<td class="market">' + value.marketCap + '</td>'
                coinList += '<td style="width:10px;height:10px"><canvas id="myChart' + value.id + '"></canvas></td>'
                coinList += '</tr>';

                $('#top').append(coinList);

                //注入折線圖至id=canvas
                var xmlHttp = new XMLHttpRequest();
                var url = "http://localhost:8080/coinshell/historical/get7daysUsdPrice?currencyName=" + value.symbol;
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                xmlHttp.onreadystatechange = function() {
                    // alert(value.id);
                    console.log(value.id)
                    if (this.readyState == 4 && this.status == 200) {
                        var data = JSON.parse(this.responseText);
                        var days = data.map(function(elem) {
                            return elem.informationDate.substr(4, 12).replace('T', '').replace('-', '').replace('-', '').replace(':', '');
                        });
                        var price = data.map(function(elem) {
                            return elem.USD_Price_of_Cryptocurrency;
                        });

                        const ctx = document.getElementById('myChart' + value.cmcRank).getContext('2d');

                        const myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: days,
                                pointHitRadius: 0,
                                datasets: [{
                                    label: 'US',
                                    data: price,
                                    backgroundColor: [
                                        'transparent'
                                    ],
                                    borderColor: 'green',
                                    borderWidth: 3,
                                    lineTension: 0,
                                }]
                            },
                            options: {
                                plugins: {},
                                elements: {
                                    line: {
                                        lineTension: 0
                                    },
                                    point: {
                                        radius: 0
                                    }
                                },
                                scales: {

                                    xAxes: [{
                                        ticks: {
                                            display: false
                                        },
                                        type: 'time',
                                        time: {
                                            unit: 'hour',
                                        },
                                        ticks: {
                                            display: false //this will remove only the label
                                        }
                                    }],
                                    yAxes: {
                                        beginAtZero: false
                                    }
                                },
                                animation: {
                                    duration: 0
                                }

                            }
                        });
                    }
                }

            })
      		window.clearTimeout(timeoutID);
            //查詢後持續即時更新
            window.setTimeout(function() { loadCoinByName() }, 60000);
            upjquery();
        },
        error: function(err) {
            console.log(err)
        }
    })
}


//function全部封裝起來 讓setinterval再跑時候讀取	

function upjquery() {

    //.toLocaleString =>千分位 
    //(undefined, {maximumFractionDigits: 0}) =>去小數點 設1則顯示小數點後1位
    //如果用 (td.toFixed(0)).toLocaleString(); 會失敗 只會顯示無小數點 但不會千分位

    $('.vol24h,.market').each(function(i, el) {
        var td = parseFloat($(el).text());
        if (!isNaN(td)) {
            $(el).text('$' + td.toLocaleString(undefined, { maximumFractionDigits: 0 }));
        }
    });


    //取小數後2位+百分比


    $('.1h,.24h,.7d,.30d').each(function(i, el) {
        var td = parseFloat($(el).text());
        if (!isNaN(td)) {
            $(el).text(td.toFixed(2) + '%');
        }
    });

    //取小數後兩位 + 前面加上錢字號

    $('.price,.price1').each(function(i, el) {
        var td = parseFloat($(el).text());
        if (!isNaN(td)) {
            $(el).text('$' + td.toFixed(2));
        }
    });


    //判斷大於0顯綠 反之顯紅


    $(function() {
        $('.1h,.24h,.7d,.30d').each(function() {
            var elem = $(this),
                value = parseFloat(elem.text());
            if (value < 0) {
                elem.css('color', 'red');
            }
            if (value > 0) {
                elem.css('color', 'green');
            }
        });
    });
}