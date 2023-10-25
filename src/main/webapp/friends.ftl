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
        ✨Friends✨
        <br>
    </div>


    <div class="flex justify-center items-center flex-col">
        <#if friends?has_content>
            <#list friends as f>
                <div class="text-pink-400 w-1/2 font-medium
                        mt-12 border border-pink-400 bg-pink-50">
                    <div class="text-ml mx-1">
                        Name: ${f.name}
                        <br>
                        Date of birth: ${f.dateOfBirth}
                        <br>
                        Zodiac sign: ${f.zodiacSign}
                        <br>
                        City: ${f.city}
                    </div>
                </div>
            </#list>
        </#if>
        <#if !friends?has_content>
            <div class="text-pink-400 w-full flex items-center justify-center font-medium text-xl mt-12">
                No friends yet
            </div>
        </#if>
    </div>
</#macro>

</html>