
<jsp:include page="include/header.jsp" />


<section class="pt-5 pb-5" style="background-color:rgb(218, 225, 234)">
    <div class="container text-center">
        <h2 class="m-0">Create New Account</h2>
    </div>
</section>

<script>

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
</script>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <form>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">* Email address</label>
                        <input type="text" placeholder="Email address" class="form-control" id="exampleInputEmail1"
                               aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" class="form-control" id="name" aria-describedby="nameHelp">
                        <div id="nameHelp" class="form-text">Let us know who you are</div>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" aria-describedby="passwordHelp">
                        <div id="passwordHelp" class="form-text">Minimum 8 characaters with uppercase, lowercase,
                            and a number</div>
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control is-invalid" id="confirmPassword"
                               aria-describedby="confirmPasswordHelp">
                        <div id="confirmPasswordHelp" class="form-text">Re-enter your password.</div>
                    </div>


                    <button type="button" id="create_btn" class="btn btn-primary mt-3 me-2" onclick="formSubmit()">Create
                        Account</button>
                    <button type="button" class="btn btn-secondary mt-3" onclick="cancelClicked()">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp" />