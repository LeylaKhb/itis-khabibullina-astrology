<html lang="en">
<#include "base.ftl">

<#macro title>✨Astrology✨</#macro>


<#macro content>
    <div class="flex h-9 items-center justify-center mt-11">
        <#if !sessionIsNull??>
            <a href="/registration">
                <button class="text-white rounded-md bg-pink-600 font-medium h-14 w-28 mx-20 my-14 text-xl
                text-center">Sign up</button>
            </a>
            <a href="/login">
                <button class="text-white rounded-md bg-pink-600 font-medium h-14 w-28 mx-20 my-14 text-xl text-center">
                    Sign in
                </button>
            </a>
        </#if>

        <#if sessionIsNull??>
            <a href="/profile">
                <img src="https://i.pinimg.com/564x/4c/3e/3b/4c3e3b91f05a5765aa544ac7557d6642.jpg" class="h-9 w-15" />
            </a>
        </#if>
    </div>

    <div class="text-pink-600 w-full flex items-center justify-center font-medium text-2xl mt-12 flex-col">
        ✨Astrology✨
        <div>
            <a href="/forum">
                <button class="text-white rounded-md bg-pink-600 font-medium h-14 w-28 mx-20 my-14 text-xl text-center">
                    Forum
                </button>
            </a>
        </div>


    </div>

    <div class="w-full items-center justify-between flex">
        <div class="w-1/2 flex items-center justify-center text-pink-600 font-medium text-xl flex-col">
            If you're not signed in:
            <a href="/daily">
                <button class="text-white rounded-md bg-pink-600 font-medium h-14 w-32 mx-20 my-14 text-xl
                text-center">Daily phrase for all</button>
            </a>
            <a href="/luckySigns">
                <button class="text-white rounded-md bg-pink-600 font-medium h-14 w-32 mx-20 text-xl
                text-center">Lucky and unlucky signs by date</button>
            </a>
        </div>
        <div class="w-1/2 flex items-center justify-center text-pink-600 font-medium text-xl flex-col" >
            If you're signed in:
            <a href="/horoscope">
                <button class="text-white rounded-md bg-pink-600 font-medium h-14 w-32 mx-20 my-14 text-xl
                text-center">Horoscope for you sign</button>
            </a>
            <a href="/compatibility">
                <button class="text-white rounded-md bg-pink-600 font-medium h-20 w-32 mx-20 text-xl
                text-center">Compatibility with your friends</button>
            </a>
        </div>
    </div>
</#macro>

</html>