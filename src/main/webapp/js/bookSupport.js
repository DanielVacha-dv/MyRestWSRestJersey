// this is the id of the form
$("#bookAddFormID").submit(function (e) {

    e.preventDefault(); // avoid to execute the actual submit of the form.

    var form = $(this);
    var url = form.attr('action');
    let data=form.serialize();
    $.ajax({
        type: "POST",
        url: url,
        timeout: 25000,
        data: data, // serializes the form's elements.
        complete: function (data) {
            processAllBooks();
        }
    });
});
function editRecord(element) {
    let trElement = element.closest("tr");
    let bookIdTag=trElement.querySelector("input[name='bookIdName']");
    let inputsArr=trElement.querySelectorAll("input");
    let urlParams="";
    for (let elem of inputsArr) {
        urlParams+="&"+elem.name+"="+elem.value;
    }
    $.ajax({
        type: "POST",
        url: "/api/bookService/editBook",
        data:"id="+bookIdTag.value+urlParams ,
        timeout: 25000,
        complete: function (data) {
            processAllBooks();
        }
    });
}
function deleteRecord(element) {
    let bookIdTag=element.parentNode.parentNode.querySelector("input[name='bookIdName']");
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/MyRestWSRestJersey/api/bookService/deleteBook?bookIdName="+bookIdTag.value,
        timeout: 25000,
        complete: function (data) {
            processAllBooks();
        }
    });
}

function processAllBooks() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/MyRestWSRestJersey/api/bookService/getAllBook",
        timeout: 25000,
        success: function (data) {
            accommodateBookTable(data)
        }
    });
}

function accommodateBookTable(data) {
    console.log(" all data=" + data);
    let bookTableBody = document.getElementById("bookOverviewTBody");
    bookTableBody.textContent = "";
    for (let i=0;i<data.content.length;i++) {
        let book =data.content[i]
        let tr = document.createElement("tr");
        let inputIDBook = document.createElement("input");
        inputIDBook.type='HIDDEN';
        inputIDBook.value=book.id;
        inputIDBook.name="bookIdName";
        inputIDBook.id="bookID_"+book.id;
        let tdPages = document.createElement("td");
        let inputBookPages = document.createElement("input");
        inputBookPages.type="number";
        inputBookPages.value=book.bookPages;
        inputBookPages.name="bookPages";
        tdPages.appendChild(inputBookPages);

        let tdName = document.createElement("td");
        let inputBookName = document.createElement("input");
        inputBookName.type="text";
        inputBookName.value=book.bookName;
        inputBookName.name="bookName";
        tdName.appendChild(inputBookName);

        let btnInTD = document.createElement("td");
        btnInTD.innerHTML="<button onclick=\"deleteRecord(this)\">smaz</button>";
        let btnEditTD = document.createElement("td");
        btnEditTD.innerHTML="<button onclick=\"editRecord(this)\">uloz</button>";
        tr.appendChild(inputIDBook);
        tr.appendChild(tdPages);
        tr.appendChild(tdName);
        tr.appendChild(btnInTD);
        tr.appendChild(btnEditTD);
        bookTableBody.appendChild(tr);
    }
}

