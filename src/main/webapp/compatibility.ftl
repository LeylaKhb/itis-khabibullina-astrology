<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Compatibility page</#macro>

<#macro content>
    <div class="ml-3 mt-3">
        <a href="/">
            <button class="text-white rounded-md bg-pink-600 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>

    <div class="text-pink-600 w-full flex items-center justify-center font-medium text-3xl mt-12 ">
        ✨Compatibility✨
    </div>



    <div class="flex justify-center mt-20">
        <form action="compatibility" method="post" >
            <div class="font-medium text-pink-600 text-ml">
                Choose your friend you want to get compatibility with:
            </div>
            <br>

            <select class="border-pink-600 text-pink-600 rounded-md " name="friend">
                <option disabled>Choose your friend</option>
                <#if friends?has_content>
                    <#list friends as f>
                        <option class="text-pink-600" value=${f.name}>${f.name}</option>
                    </#list>
                </#if>
            </select>
            <br>

            <input type="submit" value="Select" class="text-white rounded-md bg-pink-600 font-medium h-12 w-24
            mx-20 my-14 text-ml text-center" />
        </form>
    </div>


    <#if header??>
        <div class="mx-5 text-pink-600 w-full flex items-center justify-center font-medium text-xl mt-12">
            ${header}
        </div>
        <div class="mx-5 text-pink-600 w-full flex items-center justify-center font-light text-ml mt-12">
            ${text}
        </div>
    </#if>

</#macro>

</html>