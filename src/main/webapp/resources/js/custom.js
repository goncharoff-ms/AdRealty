$("#typeAd").change(function(){
    if ($(this).val() == "КУПЛЯ") {
        $("#imageBox").hide(500);
        $("#streetBox").hide(500);
        $("#numberHouseBox").hide(500);


    } else {
        $("#imageBox").show(500);
        $("#streetBox").show(500);
        $("#numberHouseBox").show(500);
    }
});