<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Horoscope page</#macro>

<#macro content>
    <div class="text-pink-400 w-full flex items-center justify-center font-medium text-3xl mt-12 ">
        Horoscope for ${zodiacSign}
    </div>
    <div class="text-pink-400 w-full flex items-center justify-center font-medium text-xl mt-12 ">
        ${horoscope}
    </div>
</#macro>

</html>