let users = [];
let grandTotal = 0;

function addItemToCart(id) {
    const name = document.getElementById("name" + id);
    const title = document.getElementById("title" + id);
    const price = document.getElementById("price" + id);

    const user = {
        "id": id,
        "name": name.innerHTML,
        "title": title.innerHTML,
        "price": price.innerHTML
    };
    users.unshift(user);
    displayItems();
    calGrandTotal();
    toggleConformationButton();
}

function displayItems() {
    const dynamicList = document.getElementById("dynamic-row");
    dynamicList.innerHTML = "";
    users.forEach(function (user) {
        dynamicList.innerHTML +=
            "<div class='container'>" +
            "    <div class='card-body '>" +
            "        <div class='row'>" +
            "           <div class='col-md-9'>" +
            "        <span>" +
            "            <i class='fa fa-user text-success' aria-hidden='true'></i>" +
            "        </span>" +
            "        <span class='name'>" + user.name +
            "        </span><br><small><cite title='Title' class='text-muted'>(" + user.title + ")</cite></small><br>" +
            "                <span class='mr-2'>Price:</span>" +
            "                 <span>₹ </span><span id='" + "cal-price" + user.id + "'>" + user.price + "</span>" +
            "    </div>" +
            "            <div class='col-md-3'>" +
            "                 <button class='btn btn-outline-danger' onclick='" + "remove(" + user.id + ");'><i class='bx bxs-trash bx-tada '  aria-hidden='true'></i></button>" +
            "            </div>" +
            "         </div>" +
            "    </div>" +
            "    <hr/>" +
            "</div>";
    });

}

function calGrandTotal() {
    grandTotal = users.reduce((a, c) => {
        return a + parseFloat(c.price);
    }, 0);
    document.getElementById('grand').innerHTML = grandTotal;
    grandTotal = 0;
}

function storeArrayInHiddenForm() {
    const form = document.getElementById("list");
    if (form.getElementsByTagName("input").length <= 1) {
        users.forEach(function (user) {
            document.getElementById("list").innerHTML +=
                "<input type='hidden' name='id' value='" + user.id + "'>";
        });
    }
    changePropertyOfConformButton();
}

function changePropertyOfConformButton() {
    let button = document.getElementById("btn-conformation");
    button.removeAttribute("onclick");
    button.setAttribute("type", "submit");
    button.innerHTML = "Continue";
    button.classList.remove('btn-outline-warning');
    button.classList.add('btn-outline-success');
}


function remove(id) {
    users = users.filter(usr => !(usr.id === id));
    enableHireButton('hire-btn' + id);
    displayItems();
    calGrandTotal();
    toggleConformationButton();
}


function toggleConformationButton() {
    if (users.length > 0) {
        document.getElementById("btn-conformation").disabled = false;
    } else {
        document.getElementById("btn-conformation").disabled = true;
    }
}

function disableHireButton(addBtn) {
    document.getElementById(addBtn).firstElementChild.disabled = true;
}

function enableHireButton(addBtn) {
    document.getElementById(addBtn).firstElementChild.disabled = false;
}

let alert = document.querySelector(".action-alert");

// Detect all clicks on the document
document.addEventListener("click", function (event) {
    // If user clicks inside the element, do nothing
    if (alert != null) {
        console.log(alert);
        if (event.target.closest(".action-alert")) return;

        // If user clicks outside the element, hide it!
        alert.classList.add("js-is-hidden");
    }

});

function querySearch() {
    let keyword = document.getElementById('search-box').value;
    console.log(keyword);
    setUrl('q', keyword);

}

function setUrl(param, paramValue) {
    let params = new URLSearchParams(location.search);
    params.set(param, paramValue);
    window.history.replaceState({}, "", location.pathname + '?' + params);
    location.reload();
}
function setLocationUrl(lat,lan) {
    let params = new URLSearchParams(location.search);
    params.set('lat', lat);
    params.set('lan', lan);
    window.history.replaceState({}, "", location.pathname + '?' + params);
    location.reload();
}

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        document.getElementById("msg").innerHTML = "Geolocation is not supported by this browser.";
    }
}

function showPosition(position) {

    console.log(position.coords.latitude+' \n'+position.coords.longitude);
    setLocationUrl(position.coords.latitude,position.coords.longitude);
}