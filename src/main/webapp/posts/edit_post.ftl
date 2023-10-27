<html lang="en">
<#include "../base.ftl">

<#macro title>Edit post</#macro>

<#macro content>
    <div class="ml-3 mt-3">
        <a href="/forum">
            <button class="text-white rounded-md bg-pink-600 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>

    <div class="flex items-center justify-center mt-32 flex-col">
        <form action="editPost" method="post">
            <div class="text-xl text-pink-600 font-medium">
                Edit post:
            </div>
            <br>

            <div class="font-medium text-pink-600 text-ml">
                Content:
                <input type="text" value=${post.content} name="content" class="border border-pink-600
            bg-pink-50 rounded-md"/>
            </div>

            <input hidden="hidden" name="id" value=${post.id}  >

            <input type="submit" value="Edit" class="text-white rounded-md bg-pink-600 font-medium h-12 w-24 mx-20
        mt-3 text-ml text-center" />
            <br>

        </form>
    </div>

</#macro>

</html>