<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Login page</#macro>

<#macro content>
    <div class="ml-3 mt-3">
        <a href="/">
            <button class="text-white rounded-md bg-pink-600 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>


    <div class="flex justify-center mt-20">
        <form action="login" method="post" >
            <div class="font-medium text-pink-600 text-ml">
                Login:
                <input type="text" name="login" placeholder="login"  class="border border-pink-600 bg-pink-50
                rounded-md"/>
            </div>
            <br>

            <div class="font-medium text-pink-600 text-ml">
                Password:
                <input type="password" placeholder="password" name="password"  class="border border-pink-600
                bg-pink-50 rounded-md"/>
            </div>

            <div class="font-medium text-pink-600 text-ml mt-2">
                <input type="checkbox" name="remember">Remember me</input>
            </div>
            <br>


            <input type="submit" value="Login" class="text-white rounded-md bg-pink-600 font-medium h-12 w-24
            mx-20 my-14 text-ml text-center" />
        </form>
    </div>

     <#if userIsNull??>
         <div class="text-pink-600 w-full flex items-center justify-center font-medium text-xl mt-12">
             User is not found
         </div>
     </#if>

    <#if wrongPassword??>
        <div class="text-pink-600 w-full flex items-center justify-center font-medium text-xl mt-12">
            Wrong password
        </div>
    </#if>

</#macro>

</html>