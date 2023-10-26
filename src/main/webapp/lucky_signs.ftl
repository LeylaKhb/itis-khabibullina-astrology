<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Friends</#macro>

<#macro content>

    <div class="ml-3 mt-3">
        <a href="/main">
            <button class="text-white rounded-md bg-pink-400 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>

    <div class="text-pink-400 w-full flex items-center justify-center font-medium text-2xl mt-12 ">
        ✨Lucky and unlucky signs✨
        <br>
    </div>

    <div class="p-10">
        <div class="dropdown inline-block relative">
            <button class="bg-gray-300 text-gray-700 font-semibold py-2 px-4 rounded inline-flex items-center">
                <span class="mr-1">Dropdown</span>
                <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/> </svg>
            </button>
            <ul class="dropdown-menu absolute hidden text-gray-700 pt-1">
                <li class=""><a class="rounded-t bg-gray-200 hover:bg-gray-400 py-2 px-4 block whitespace-no-wrap" href="#">One</a></li>
                <li class=""><a class="bg-gray-200 hover:bg-gray-400 py-2 px-4 block whitespace-no-wrap" href="#">Two</a></li>
                <li class=""><a class="rounded-b bg-gray-200 hover:bg-gray-400 py-2 px-4 block whitespace-no-wrap" href="#">Three is the magic number</a></li>
            </ul>
        </div>
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