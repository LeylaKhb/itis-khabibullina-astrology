<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Lucky and unlucky signs</#macro>

<style>
    .dropdown:hover .dropdown-menu {
        display: block;
    }
</style>

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

    <div class="p-10 flex items-center justify-center">
        <div class="dropdown inline-block relative ">
            <button class="bg-pink-50 text-pink-400 font-semibold py-2 px-4 rounded inline-flex items-center">
                <span class="mr-1">Choose zodiac sign</span>
                <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/>
                </svg>
            </button>
            <ul class="dropdown-menu absolute hidden text-pink-400 pt-1">
                <#if zodiacSigns?has_content>
                    <#list zodiacSigns as z>
                        <li class="">
                        <a class="rounded-t bg-pink-50 hover:bg-pink-200 py-2 px-4 block whitespace-no-wrap"
                           href="/luckySigns?sign=${z}">${z}</a></li>
                    </#list>
                </#if>
            </ul>
        </div>
    </div>

    <div class="p-10 flex items-center justify-center">
        <form method="post" action="luckySigns">
            <input type="text" name="search" class="border border-pink-400 bg-pink-50
                rounded-md font-medium text-pink-400 text-ml"/>

            <input type="submit" value="Search" class="text-white rounded-md bg-pink-400 font-medium h-12 w-24
            text-ml text-center" />
        </form>
    </div>


<div class="flex justify-center items-center flex-col">
        <#if luckyZodiacSigns?has_content>
            <#list luckyZodiacSigns as z>
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