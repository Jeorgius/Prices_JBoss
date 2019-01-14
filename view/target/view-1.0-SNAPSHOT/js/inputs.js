var d = document;
var addPriceButton = d.getElementById("addPrice");

function addPrices() {
    var priceForm = d.getElementById("price");
    var inputs = priceForm.getElementsByTagName("input");

    var value = d.createElement("input");
    value.setAttribute("type","number");
    value.setAttribute("name","value");

    var dateBegin = d.createElement("input");
    dateBegin.setAttribute("type","datetime-local");
    dateBegin.setAttribute("name","date_begin");
    dateBegin.setAttribute("step","1");

    var dateEnd = d.createElement("input");
    dateEnd.setAttribute("type","datetime-local");
    dateEnd.setAttribute("name","date_end");
    dateEnd.setAttribute("step","1");

    priceForm.insertBefore(d.createElement("br"),addPriceButton);
    priceForm.insertBefore(value,addPriceButton);
    priceForm.insertBefore(d.createElement("br"),addPriceButton);
    priceForm.insertBefore(dateBegin,addPriceButton);
    priceForm.insertBefore(d.createElement("br"),addPriceButton);
    priceForm.insertBefore(dateEnd,addPriceButton);
    priceForm.insertBefore(d.createElement("br"),addPriceButton);
}

addPriceButton.addEventListener("click",addPrices);