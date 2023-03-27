
<jsp:include page="include/header.jsp" />

<link rel="stylesheet" href="/pub/css/global.css">

<section class="pt-5 pb-5" style="background-color:bisque">
    <div class="container">

        <h1 class="pb-2" style="text-align: center;">This is the page title</h1>


        <h1>This is our first page notice it change</h1>
        <h2>This is our first page notice it change</h2>
        <h3 style="color:red;">This is our first page notice it change</h3>
        <h4>This is our first page notice it change</h4>

        <p id="paragraph">This is a paragraph with some <strong>bold</strong> text with <a href="https://google.com"
                                                                                           target="_new">a link in
            it</a></p>

        <img width="150px"
             src="https://static.seriesreminder.com/tvdb/sr_poster/v4/series/385376/posters/6390c46086be6.jpg"/>
        <br>
        <br>

        <ul>
            <li>Line Item 1</li>
            <li>Line Item 2</li>
            <li>Line Item 3</li>
        </ul>


        <table border="1">
            <tr>
                <td>Column 1</td>
                <td>Column 2</td>
                <td>Column 3</td>
            </tr>
            <tr>
                <td>Data 1</td>
                <td>Data 2</td>
                <td>Data 3</td>
            </tr>
            <tr>
                <td>Something</td>
                <td>Else</td>
                <td>Here</td>
            </tr>
        </table>
    </div>
</section>
<section class="pt-5 pb-5" style="background-color: blanchedalmond;">
    <div class="container">
        <h2 style="text-align: center;">This is the 2nd section on the page</h2>
    </div>

    <div>
        @Scheduled(cron = "0 0 10 * * ?")
        public void runNotifications() {
        if (isEnabled) {
        try {
        processNotifications();
        } catch (Exception e) {
        log.error("Failed to process notificiations", e);
        }
        }
        }
    </div>
    <br><br>
    <pre>
            @Scheduled(cron = "0 0 10 * * ?")
            public void runNotifications() {
                if (isEnabled) {
                    try {
                        processNotifications();
                    } catch (Exception e) {
                        log.error("Failed to process notificiations", e);
                    }
                }
            }
        </pre>
</section>


<section>
    <div class="container">
        <h3>Information about the Window</h3>
        <table border="2">
            <tr>
                <th>outerWidth:</th>
                <td id="ow"></td>
                <th>outerHeight:</th>
                <td id="oh">
            </tr>
            <tr>
                <th>innerWidth:</th>
                <td id="iw"></td>
                <th>innerHeight:</th>
                <td id="ih"></td>
            </tr>
        </table>
        <script>
            document.getElementById("ow").innerHTML = window.outerWidth;
            document.getElementById("oh").innerHTML = window.outerHeight;
            document.getElementById("iw").innerHTML = window.innerWidth;
            document.getElementById("ih").innerHTML = window.innerHeight;
        </script>
    </div>
</section>


<jsp:include page="include/footer.jsp" />