<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Friends</#macro>

<#macro content>

    <div class="ml-3 mt-3">
        <a href="/profile">
            <button class="text-white rounded-md bg-pink-400 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>

    <div class="text-pink-400 w-full flex items-center justify-center font-medium text-2xl mt-12 ">
        ✨Lucky and unlucky signs✨
        <br>
    </div>


    <div class="flex justify-center items-center flex-col">
        <#if zodiacSigns?has_content>
            <#list zodiacSigns as z>
                <div class="text-pink-400 w-1/2 font-medium
                        mt-12 border border-pink-400 bg-pink-50 text-ml mx-3">
                    Date: ${z.dateOfLuck}
                    <br>
                    Lucky zodiac sign: ${z.luckyZodiacSign}
                    <br>
                    Unlucky zodiac sign: ${z.unluckyZodiacSign}
                    <br>
                </div>
            </#list>
        </#if>
    </div>
</#macro>

</html>