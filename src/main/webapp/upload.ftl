<html lang="en">
<#include "base.ftl">

<#macro title>Upload file</#macro>

<#macro content>
    <div class="flex justify-center mt-20">
        <form action="upload" method="post" enctype="multipart/form-data">
            <div class="font-medium text-pink-400 text-ml">
                Upload file:
                <br>
                <input type="file" name="file" class="border border-pink-400 bg-pink-50 rounded-md"/>
                <br>
                <input type="submit" value="Upload" class="text-white rounded-md bg-pink-400 font-medium h-12 w-24
                mx-20 my-14 text-ml text-center">
            </div>
        </form>
    </div>
    <br>
</#macro>

</html>