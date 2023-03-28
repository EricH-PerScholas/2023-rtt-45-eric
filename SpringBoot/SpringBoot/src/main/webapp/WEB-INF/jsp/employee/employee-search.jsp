<jsp:include page="../include/header.jsp"/>

<section class="pt-5 pb-5 bg-dark-grey">
    <div class="container text-center">
        <h1>Employee Search</h1>
    </div>
</section>

<section class="pt-5 pb-5 bg-light-grey">
    <div class="container">
        <div class="row text-center justify-content-center">
            <div class="col-7">
                <form>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="search" placeholder="Employee First Name"
                               aria-label="Employee First Name" aria-describedby="search">
                        <button class="btn btn-outline-secondary" id="search">Search</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section class="pt-5 pb-5 bg-dark-grey">
    <div class="container text-center">
        <table class="table table-striped border">
            <thead>
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Job Title</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
            </tbody>
        </table>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>