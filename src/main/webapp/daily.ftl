<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Daily phrase page</#macro>

<head>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).on("click", "#ajax-button", function () {
            $.get("/daily/get", function (response) {
                $("#ajax-response").text(response);
            })
        })
    </script>
</head>

<#macro content>

    <div class="ml-3 mt-3">
        <a href="/">
            <button class="text-white rounded-md bg-pink-400 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>

    <div class="text-pink-400 w-full flex items-center justify-center font-medium text-3xl mt-12 ">
        ✨Your daily phrase✨
    </div>

    <div class="flex justify-center mt-20">
        <form>
            <input type="button" id="ajax-button" value="Get daily phrase" class="text-white rounded-md bg-pink-400
            font-medium h-12 w-36 mx-20 my-14 text-ml text-center" />
        </form>
    </div>

    <div id="ajax-response" class="text-pink-400 w-full flex items-center justify-center font-medium text-xl mt-12 ">

    </div>
</#macro>

</html>