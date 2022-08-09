<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextRoot}/css/backendNews.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="${contextRoot}/javascripts/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>News | CoinShell Backend</title>
</head>
<body>
<p />

<div id="test">
	<table class="table table-hover" id="newsAddTable">
        <thead class="bg-success">
            <tr>
                <th scope="col" style="width:25%;">Title</th>
                <th scope="col" style="width:35%;">Url</th>
                <th scope="col" style="width:35%;">ImgUrl</th>
                <th scope="col" style="width:5%;">Add</th>
            </tr>
        </thead>
            <tr>
            <td style="width:25%;"><input type="text" size="55%" id="newsAddTitle"></td>
            <td style="width:35%;"><input type="text" size="81%" id="newsAddUrl"></td>
            <td style="width:35%;"><input type="text" size="81%" id="newsAddImgUrl"></td>
            <td style="width:5%;"><input type="button" style="width:100%;" class="btn btn-success" value="Add" onClick="add()"></td>
            </tr>
    </table>
            
    <table class="table table-hover" id="newsUpdateTable">
        <thead class="bg-info">
            <tr>
                <th scope="col" style="width:4%;">ID</th>
                <th scope="col" style="width:20%;">Title</th>
                <th scope="col" style="width:35%;">Url</th>
                <th scope="col" style="width:35%;">ImgUrl</th>
                <th scope="col" style="width:6%;">Update</th>
            </tr>
        </thead>
        	<tr>
               <td>ID</td>
               <td><input type="text" size="42%" id="newsUpdateTitle"></td>
               <td><input type="text" size="81%" id="newsUpdateUrl"></td>
               <td><input type="text" size="81%" id="newsUpdateImgUrl"></td>
               <td><button  style="width:100%;"class="btn btn-info" onClick="">Update</button></td>
            </tr>
    </table>
                                    
                                    
    <form class="form-inline my-1 my-lg-0">
		<div class="input-group">
			<input id="newsTitle" class="form-control pl-2 p-0" type="text" aria-label="Search">
			<div class="input-group-append">
				<input type="button" name="submit" value="Search" id="searchNews" class="btn btn-outline-dark my-2 my-sm-0" />
            </div>
        </div>
        <hr />
        <nav aria-label="Page navigation example">
            <ul class="pagination newsBtn" id="pageid">
            </ul>
        </nav>
    </form>

	<table class="table table-hover" id="newsTable">
        <thead class="bg-primary">
            <tr>
                <th scope="col" class="id"    >ID</th>
                <th scope="col" class="title" >Title</th>
                <th scope="col" class="url"   >Url</th>
                <th scope="col" class="imgUrl">ImgUrl</th>
                <th scope="col" class="date"  >Date</th>
                <th scope="col" class="update">Update</th>
                <th scope="col" class="delete">Delete</th>
            </tr>
        </thead>
        <tbody id="newsTbody">
        </tbody>
    </table>
     </div>
                         <div id="ttest"></div>
</body>                           
<script>
$("#searchNews").click(function() {
	loadNewsByTitle();
});

let dataNow ={};
getNews();
// allNews();

pageid.addEventListener('click',switchPage);

function switchPage(e){
e.preventDefault();
if(e.target.nodeName !== 'A') return;
const page = e.target.dataset.page;
pagination(dataNow, page);
}

function getNews(){
    $.ajax({
        url: "http://localhost:8080/coinshell/news/getAll",
        contentType: 'application/json; charset=UTF-8', 
        dataType: 'json', 
        method: 'get',
        success: function(data) {
            console.log(data);
            dataNow = data;
            pagination(data, 1)
        },
        error: function(err) {
            console.log(err)
        }
})
}

function pagination(array, nowPage){
                console.log(nowPage);
                const dataTotal = array.length;
                const perpage = 15;
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
    $('#newsTbody').empty();
    $.each(data, function(index, value) {                
                newsList  = '';
            	
            	newsList += '<tr>'
            	newsList += '<td>' + value.id + '</td>'
                newsList += '<td class="title">' + value.title + '</td>'
                newsList += `<td><a href="" onclick="window.open('` + value.url + `')">` + value.url + `</a></td>`
	            newsList += '<td><img class="newsImg" src="' + value.imgUrl + '"alt=""><a href="' + value.imgUrl + '"></a></td>'
                newsList += '<td>' + value.date + '</td>'
                newsList += '<td><button id="up'  + value.id + '" class="btn btn-info" value="' + value.id + '" onClick="update(this)">Update</button></td>'
                newsList += '<td><button id="del' + value.id + '" class="btn btn-danger"  value="' + value.id + '" onClick="del(this)">Delete</button></td>'
                newsList += '</tr>';
                
                $('#newsTable').append(newsList);
                })
}

function pageBtn (page){
    let str = '';
    const total = page.pageTotal;
    if(page.hasPage) {
        str += `<li class="page-item"><a class="page-link" href="#" data-page="`+(Number(page.currentPage)-1)+`">Previous</a></li>`;
    } else {
        str += `<li class="page-item disabled"><span class="page-link">Previous</span></li>`;
    }
    
    for(let i = 1; i <= total; i++){
        if(Number(page.currentPage) === i) {
            str +=`<li class="page-item active"><a class="page-link" href="#" data-page="`+i+`">`+i+`</a></li>`;
        } else {
            str +=`<li class="page-item"><a class="page-link" href="#" data-page="`+i+`">`+i+`</a></li>`;
        }
    };

    if(page.hasNext) {
        str += `<li class="page-item"><a class="page-link" href="#" data-page="`+(Number(page.currentPage)+1)+`">Next</a></li>`;
    } else {
        str += `<li class="page-item disabled"><span class="page-link">Next</span></li>`;
    }
    pageid.innerHTML = str;    
    console.log(str);
}

// function allNews() {
//     $.ajax({
//         url: "http://localhost:8080/coinshell/news/getAll",
//         contentType: 'application/json; charset=UTF-8', 
//         dataType: 'json', 
//         method: 'get',
//         success: function(result) {
//             console.log(result)
//             $.each(result, function(index, value) {
//             	newsList  = '';
            	
//             	newsList += '<tr>'
//             	newsList += '<td>' + value.id + '</td>'
//              newsList += '<td class="title">' + value.title + '</td>'
//              newsList += `<td><a href="" onclick="window.open('` + value.url + `')">` + value.url + `</a></td>`
// 	            newsList += '<td><img class="newsImg" src="' + value.imgUrl + '"alt=""><a href="' + value.imgUrl + '"></a></td>'
//              newsList += '<td>' + value.date + '</td>'
//              newsList += '<td><button id="up'  + value.id + '" class="btn btn-info" value="' + value.id + '" onClick="update(this)">Update</button></td>'
//              newsList += '<td><button id="del' + value.id + '" class="btn btn-danger"  value="' + value.id + '" onClick="del(this)">Delete</button></td>'
//              newsList += '</tr>';
                
//              $('#newsTable').append(newsList);
//             })
//         },
//         error: function(err) {
//             console.log(err)
//         }
//     })
// }


function add(){
	var title = document.getElementById("newsAddTitle").value;
	var url = document.getElementById("newsAddUrl").value;
	var imgUrl = document.getElementById("newsAddImgUrl").value;
	
	var param = {
			"title" : title,
			"url" : url,
			"imgUrl" : imgUrl,
		}
	 $.ajax({
	        url: 'http://localhost:8080/coinshell/news/add',
	        contentType: 'application/json; charset=UTF-8', 
	        dataType: 'json', 
	        method: 'post',
	        data : JSON.stringify(param),
	        success: function(result) {
	            console.log(result)
	            console.log("成功");
	            parent.location.reload();
// 	            document.querySelector('#ttest').scrollIntoView()
	        },
	        error: function(err) {
	            console.log(err)
	            console.log("失敗");
	        }
	    })
	}


function del(obj) {
	var r = confirm("確定刪除嗎?");
	if(r==true){
	var id = $(obj).val();
	var param = {
			"id" : id,
		}
	console.log("delId==" + id);
	$.ajax({
		url : 'http://localhost:8080/coinshell/deleteNews/'+ id,
		contentType : 'application/json; charset=UTF-8',
		dataType : 'json',
		method : 'delete',
		data : JSON.stringify(param),
		success : function(result) {
			console.log("result====" + result.status)
			console.log("成功");
			if (result.status == '200') {
			$('#newsTbody').find('[id="del' + id + '"]').closest('tr').remove();
			}
		},
		error : function(err) {
			console.log("result====" + err)
			console.log("失敗");
		}
	})
	}
}


function loadNewsByTitle() {
    var Title = document.getElementById("newsTitle").value;
    $.ajax({
        url: 'http://localhost:8080/coinshell/news/select?title=' + Title,
        contentType: 'application/json; charset=UTF-8', 
        dataType: 'json', 
        method: 'get',
        success: function(data) {
            console.log(data);
            dataNow = data;
            pagination(data, 1)
        },
        error: function(err) {
            console.log(err)
        }
    })
}

function update(obj) {
	var id = $(obj).val();
    $.ajax({
        url: "http://localhost:8080/coinshell/newsId?id=" + id,
        contentType: 'application/json; charset=UTF-8', 
        dataType: 'json', 
        method: 'get',
        success: function(result) {
        	 $('#newsUpdateTable tr td').remove();
            console.log(result)
            $.each(result, function(index, value) {
            	newsList  = '';
            	
            	newsList += '<tr>'
            	newsList += '<td>' + value.id + '</td>'
                newsList += '<td><input type="text" size="42%" id="newsUpdateTitle" value="' + value.title + '"></td>'
                newsList += '<td><input type="text" size="81%" id="newsUpdateUrl" value="' + value.url + '"></td>'
	            newsList += '<td><input type="text" size="81%" id="newsUpdateImgUrl" value="' + value.imgUrl + '"></td>'
                newsList += '<td><button  style="width:100px;" class="btn btn-info" value="' + value.id + '"onClick="upSave(this)">Update</button></td>'
                newsList += '</tr>';
                
                $('#newsUpdateTable').append(newsList);
                document.querySelector('#test').scrollIntoView()
            })
        },
        error: function(err) {
            console.log(err)
        }
    })
}

function upSave(obj){
	var id = $(obj).val();
	console.log("id====" + id)
	var title = document.getElementById("newsUpdateTitle").value;
	var url = document.getElementById("newsUpdateUrl").value;
	var imgUrl = document.getElementById("newsUpdateImgUrl").value;
	
	var param = {
			"id":id,
			"title" : title,
			"url" : url,
			"imgUrl" : imgUrl,
		}
	 $.ajax({
	        url: 'http://localhost:8080/coinshell/news/upSave',
	        contentType: 'application/json; charset=UTF-8', 
	        dataType: 'json', 
	        method: 'post',
	        data : JSON.stringify(param),
	        success: function(result) {
	            console.log(result)
	            console.log("成功");
	            parent.location.reload();
	        },
	        error: function(err) {
	            console.log(err)
	            console.log("失敗");
	        }
	    })
	}



</script>
</html>