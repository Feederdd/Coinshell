<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../NavBar/CoinShellNavBar.jsp" />
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextRoot}/css/article.css">
<title>Beach Town | Coinshell</title>
<style type="text/css">
body{
padding-top: 82px;
}
</style>
</head>

<body>
<div class="row justify-content-center">
<div class="col-9">
    <div class="article-head d-flex justify-content-between" id="searchByTag">
        <div class="row">            
            <select id="tag-list"></select>        
            <input id="titlePart" type="text" placeholder="Keyword (Title/Content)"/>
            <input type="button" name="submit" value="Search" id="search"/>
        </div>
        <a href="${contextRoot}/article/add" id="addAtc" onclick="verifyMembership()" class="btn btn-primary btn-sm shadow-none">Post New Article</a>
    </div>
    
	<table class="table table-hover table-primary table-article">
		<thead class="thead-dark">
			<tr>
				<th scope="col" class="col-2">Cryptocurrencies</th>
				<th scope="col" class="col-6">Article</th>
				<th scope="col" class="col-2" style="text-align: center;">Like / Read / Comment</th>
				<th scope="col" class="col-2">Author</th>
			</tr>
		</thead>
		<tbody class="sel" id="atcTable">
		
		</tbody>
        <nav aria-label="Page navigation example pagination-outer">
            <ul class="pagination" id="pageid">
            </ul>
        </nav>
	</table>
</div>
</div>
<script type="text/javascript">
var contextRoot = "http://localhost:8080/coinshell";
//下拉選單相關
var tag;
// var page = 1;
let dataNow = {};
tagList();
loadAtc();
$("#tag-list").change(function(){loadAtc();})
$("#search").click(function(){loadAtcByTitle();})
// addAtc.addEventListener('click',verifyMembership);

function verifyMembership(){
    return false;
    if ("${login == null }" == "true") {
        $('#loginModal').modal("show")
        }
}

var test = document.getElementById("addAtc");
function stopDefault(e) {
    if ("${login == null }" == "true"){
        e.preventDefault();
        $('#loginModal').modal("show")
    }
}

test.onclick = function(e){stopDefault(e)}

function loadAtc(){
    $(function() {
        var tag = document.getElementById("tag-list").value;
        console.log(tag);
        fetch("http://localhost:8080/coinshell/article/viewAllAjax?tag="+tag).then(function(response) {
            return response.json();
            // console.log(response.json())
        }).then(function(data) {
            console.log(data);
            dataNow = data;
            pagination(data, 1)
        })
    })
}

function loadAtcByTitle(){
    $(function() {
        var titlePart = document.getElementById("titlePart").value;
        console.log(tag);
        fetch("http://localhost:8080/coinshell/article/viewAllAjaxByTitle?titlePart="+titlePart).then(function(response) {
            return response.json();
            // console.log(response.json())
        }).then(function(data) {
            console.log(data);
            dataNow = data;
            pagination(data, 1)
        })
    })
}

function loadAtcByAuthorId(authorId){
    $(function() {
        console.log(authorId);
        fetch("http://localhost:8080/coinshell/article/viewAllAjaxByAuthorId?authorId="+authorId).then(function(response) {
            return response.json();
            // console.log(response.json())
        }).then(function(data) {
            console.log(data);
            dataNow = data;
            pagination(data, 1)
        })
    })
}

function loadAtcByGoods(){
    $(function() {
        fetch("http://localhost:8080/coinshell/article/viewArticleByGoods").then(function(response) {
            return response.json();
            // console.log(response.json())
        }).then(function(data) {
            console.log(data);
            dataNow = data;
            pagination(data, 1)
        })
    })
}

pageid.addEventListener('click',switchPage);

function switchPage(e){
e.preventDefault();
if(e.target.nodeName !== 'A') return;
const page = e.target.dataset.page;
pagination(dataNow, page);
}

function tagList(){
    var inner = "";
    var tags = ['All','BTC', 'ETH', 'USDT', 'USDC', 'BNB', 'XRP', 'ADA', 'BUSD', 'SOL', 'DOGE', 'DOT', 'AVAX', 'WBTC', 'TRX', 'SHIB', 'DAI', 'MATIC', 'CRO', 'LEO', 'LTC', 'NEAR', 'FTT', 'BCH', 'UNI', 'LINK', 'XLM', 'ATOM', 'ALGO', 'XMR', 'FLOW', 'ETC', 'APE', 'MANA', 'HBAR', 'EGLD', 'VET', 'ICP', 'FIL', 'SAND', 'XTZ', 'MKR', 'ZEC', 'KCS', 'THETA', 'CAKE', 'EOS', 'AXS', 'TUSD', 'GRT', 'AAVE', 'UST', 'KLAY', 'HT', 'RUNE', 'HNT', 'BTT', 'BSV', 'MIOTA', 'USDP', 'XEC', 'FTM', 'GMT', 'QNT', 'USDN', 'NEXO', 'STX', 'OKB', 'NEO', 'WAVES', 'CHZ', 'CVX', 'KSM', 'ZIL', 'ENJ', 'DASH', 'CELO', 'LRC', 'CRV', 'GALA', 'PAXG', 'BAT', 'AMP', 'GNO', 'ONE', 'XDC', 'AR', 'MINA', 'XEM', 'DCR', 'KDA', 'COMP', 'HOT', 'KAVA', 'LDO', 'GT', 'FEI', 'QTUM', 'BNT', '1INCH', 'XYM']
    for(var i=0;i<tags.length;i++){
            //inner第一行就會像是 <option value=0>商學院</option>
            inner=inner+`<option value=`+tags[i]+`>`+tags[i]+`</option>`;
            // inner=inner+`tagList.put("`+tags[i]+`", "`+tags[i]+`");`
        }
    $("#tag-list").html(inner)
}

function pagination(array, nowPage){
                console.log(nowPage);
                const dataTotal = array.length;
                const perpage = 5;
                const pageTotal = Math.ceil(dataTotal / perpage);
                console.log(`全部資料:`+dataTotal+` 每一頁顯示:`+perpage+`筆`);
                let currentPage = nowPage;
                if (currentPage > pageTotal) {currentPage = pageTotal;}
                const minData = (currentPage * perpage) - perpage + 1 ;
                const maxData = (currentPage * perpage) ;
                const data = [];
                array.forEach((item, index) => {
                    const num = index + 1;
                    if ( num >= minData && num <= maxData) {
                        data.push(item);
                    }
                })
                console.log(data);
                displayData(data)
                const page = {
                    pageTotal,
                    currentPage,
                    hasPage: currentPage > 1,
                    hasNext: currentPage < pageTotal,
                } 
                console.log(page);
                pageBtn (page)
            }

function displayData(data){
    $("#atcTable").empty();
    $.each(data, function(index, value) {
                const added = new Date(Date.parse(value.added));
                const MM = added.getMonth()+1;
                const dd = added.getDate();
                const HH = added.getHours();
                const mm = added.getMinutes();
                const weekIndex = added.getDay();
                const weekDay = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
                const weekDayPrint = weekDay[weekIndex];  
                const peek = value.text.substr(0,100);
                // console.log(peek);
                // console.log(array);
                     $("#atcTable").append(`
                        <tr class="table-info">
                        <td><img class="tagImg" src="`+contextRoot+`/images/currencyIcon/`+value.tag+`.png" alt="">` + value.tag + `</td>
                        <td><a href="`+contextRoot+`/viewArticle/` + value.id + `" style="display: block;"><div class="b-list"><div>` + value.title + `</div></a><p>` + peek + `....</p></div></td>
                        <td align="center">
                            <label><input type="checkbox" class="check" checked><span class="heart"><i class="fa-solid fa-heart"></i></span>`+value.goodNum+`</label>
                            <i class="fa fa-eye" aria-hidden="true"></i>` + value.readNum + `
                            <i class="fa fa-commenting-o" aria-hidden="true"></i>` + value.commentNum + `</td>
                        <td>
                            <div class="b-list">
                                <span><a href="#" style="display: block;" onclick="loadAtcByAuthorId(`+value.authorId+`)">` + value.CustomizedUserName + `</a></span>                                    
                                <span class="text-black-50">`+MM+`/`+dd+` `+HH+`:`+mm+` `+weekDayPrint+`</span>
                            </div>
                        </td>
                        </tr>
                    `)
                }
              
            )}

function pageBtn (page){
    let str = '';
    const total = page.pageTotal;
    if(page.hasPage) {
        str += `<li class="page-item"><a class="page-link" href="#" data-page="`+(Number(page.currentPage)-1)+`">«</a></li>`;
    } else {
        str += `<li class="page-item disabled"><a class="page-link">«</a></li>`;
    }
    
    for(let i = 1; i <= total; i++){
        if(Number(page.currentPage) === i) {
            str +=`<li class="page-item active"><a class="page-link" href="#" data-page="`+i+`">`+i+`</a></li>`;
        } else {
            str +=`<li class="page-item"><a class="page-link" href="#" data-page="`+i+`">`+i+`</a></li>`;
        }
    };

    if(page.hasNext) {
        str += `<li class="page-item"><a class="page-link" href="#" data-page="`+(Number(page.currentPage)+1)+`">»</a></li>`;
    } else {
        str += `<li class="page-item disabled"><a class="page-link">»</a></li>`;
    }
    pageid.innerHTML = str;    
    console.log(str);
}

// function loadAtcByTitle(){
//     $(function() {
//         var titlePart = document.getElementById("titlePart").value;
//         console.log(titlePart);
//         $("#atcTable").empty();    
//         fetch("http://localhost:8080/coinshell/article/viewAllAjaxByTitle?titlePart="+titlePart).then(function(response) {
//             return response.json();
//             // console.log(response.json())
//         }).then(function(array) {
//             $.each(array, function(index, value) {
//                 var added = new Date(Date.parse(value.added));
//                 var MM = added.getMonth();
//                 var dd = added.getDate();
//                 var HH = added.getHours();
//                 var mm = added.getMinutes();
//                 var weekIndex = added.getDay();
//                 var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
//                 var weekDayPrint = weekDay[weekIndex];  
//                 var peek = value.text.substr(0,100);
//                 // console.log(peek);
//                 // console.log(array);
//                 $("#atcTable").append(`
//                         <tr class="table-info">
//                         <td>` + value.tag + `</td>
//                         <td><a href="`+contextRoot+`/viewArticle/` + value.id + `" style="display: block;"><div class="b-list"><div><h3>` + value.title + `</h3></div></a><p>` + peek + `....</p></div></td>
//                         <td align="center">` + value.readNum + ` / ` + value.commentNum + `</td>
//                         <td>`+MM+`/`+dd+` `+HH+`:`+mm+` `+weekDayPrint+`</td>
//                     	</tr>
//                         `)
//             })
//         })
//     })
// }

// function loadAtcByTag() {
//     $(function() {
//         $("#atcTable").empty();
//         fetch("http://localhost:8080/myapp/article/viewAllAjax?Tag="+tag).then(function(response) {
//             return response.json();
//             console.log(response.json())
//         }).then(function(array) {
//             $.each(array, function(index, value) {
//                 var added = new Date(Date.parse(value.added));
//                 var MM = added.getMonth();
//                 var dd = added.getDate();
//                 var HH = added.getHours();
//                 var mm = added.getMinutes();
//                 var weekIndex = added.getDay();
//                 var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
//                 var weekDayPrint = weekDay[weekIndex];  
//                 console.log(array);
//                 $("#atcTable").append(`
//                         <tr class="table-info">
//                         <td>` + value.tag + `</td>
//                         <td><a href="`+contextRoot+`/viewArticle/` + value.id + `" style="display: block;"><div class="b-list"><div>` + value.title + `</div><p>` + value.peek + `</p></div></a></td>
//                         <td align="center">` + value.read_Num + ` / ` + value.comment_Num + `</td>
//                         <td>`+MM+`/`+dd+` `+HH+`:`+mm+` `+weekDayPrint+`</td>
//                     	</tr>
//                         `)
//             })
//         })

//     })
// }

// function loadPage(){
//     var s = "";
//     var name = $("#name").val;
//     var max = 1;
//     var min = 1;
//     fetch("zys.php").then(function(response){
//         return response.text().trim();
//     }).then(function(data){
//         min = data;
//     })
// }
//****fetch與ajax改寫

// <fmt:formatDate pattern="MM/dd EE HH:mm" value=""/>
// <fmt:parseDate pattern="MM/dd EE HH:mm" value=""/>
// <td>` + value.deleted + `</td>
// <td>` + value.id + `</td>
// <td>` + value.author_Id + `</td>
// <td>` + value.text + `</td>
// <td>` + value.peek + `</td>
// <td>` + value.read_Num + `</td>

//設定間隔時間
// window.setInterval(function() {
//     upCoin()
// }, 5000);


</script>
</body>