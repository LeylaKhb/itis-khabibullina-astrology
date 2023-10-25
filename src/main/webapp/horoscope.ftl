<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Horoscope page</#macro>

<#macro content>
    <div class="ml-3 mt-3">
        <a href="/">
            <button class="text-white rounded-md bg-pink-400 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>

    <div class="text-pink-400 w-full flex items-center justify-center font-medium text-3xl mt-12 ">
        ✨Horoscope for ${zodiacSign}✨
    </div>
    <div class="px-10 text-pink-400 w-full flex items-center justify-center font-medium text-xl mt-12 ">
        ${horoscope}
    </div>
</#macro>

</html>