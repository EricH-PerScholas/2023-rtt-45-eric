document.getElementById("create_btn").addEventListner('click', formSubmit());

function cancelClicked() {
    //event.preventDefault();
    //alert("Cancel Clicked");

    let items = document.querySelectorAll('.is-invalid');
    // i represents each element in the list items
    for (i of items) {
        console.log(i);
        let item = i;
        item.classList.remove("is-invalid");
    }

    console.log("Next message is NaN")
    console.log("item = " - " something")

    console.log(5 + "5");

    let x = "abc-abc-abc"
    console.log(x.lastIndexOf("b"));

    console.log(x.substring(2, 5));


    var y = "abc";
    var y = "123";

    // const - create once - assign once
    // let - create once - assign many
    // var - cretate many - assign many

    let car = {
        "make": "ford",
        "model": "F150",
        "year": 2023
    }

    for (k in car) {
        console.log(k + " = " + car[k]);
    }

    console.log(8 == "8")
    console.log("8" == "8")
    console.log("8" === 8)


    dates();
    arrayForEach();
}

function arrayForEach() {
    console.log("================ start arrays for each ====================");
    let sum = 0;
    const numbers = [65, 44, 12, 4, 6];
    numbers.forEach(myFunction);

    function myFunction(item) {
        sum += item;
    }

    console.log(sum);
}

function dates() {
    var date = new Date("Thu Jan 29 2009 17:31:44");
    var dat1 = new Date("2019-01-24 18:31:44");

    let today = new Date("2023-03-23 14:58:36")
    let now = new Date();
    console.log("================ start dates ====================");

    console.log(now.getMonth() === today.getMonth());
    console.log(now.getYear() === today.getYear());

}

function formSubmit() {
    let emailInput = document.getElementById('exampleInputEmail1');
    let emailValue = emailInput.value;

    console.log(emailValue);

    if (emailValue == '') {
        //alert("Email is required");
        // add the bootstrap class is-invalid to show an error
        emailInput.classList.add("is-invalid");
        // this will set the value of the email input field to what ever text
        emailInput.value = "Enter your email";
        // now we can add an individal style property on the input field for color
        //emailInput.style.color = 'red';

        // here we can change the CSS in the style tag to be what we want
        emailInput.style.cssText = "color:green;"

        document.getElementById('emailHelp').innerHTML = "<p>Please enter your email address</p>";
        document.getElementById('emailHelp').style.cssText = "color:red;";
    }

}