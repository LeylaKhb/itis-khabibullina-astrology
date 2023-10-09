<html lang="en">
<#include "base.ftl">

<#macro title>✨Astrology✨</#macro>


<#macro content>
    <div style="display: flex; height: 30px; align-items: center; justify-content: center; margin-top: 50px">
        <#if sessionIsNull>
            <a href="/registration">
                <button style="height: 60px; width: 120px; font-weight: 500; --tw-bg-opacity: 1;
    background-color: rgb(221 160 223  / var(--tw-bg-opacity)); margin: 100px 50px 100px; border-radius: 6px; --tw-text-opacity: 1;
    color: rgb(255 255 255 / var(--tw-text-opacity)); font-size: 20px;">Sign up</button>
            </a>
            <a href="/login">
                <button style="height: 60px; width: 120px; font-weight: 500; --tw-bg-opacity: 1;
    background-color: rgb(221 160 223  / var(--tw-bg-opacity)); margin: 100px 50px 100px; border-radius: 6px; --tw-text-opacity: 1;
    color: rgb(255 255 255 / var(--tw-text-opacity)); font-size: 20px;">
                    Sign in
                </button>
            </a>
        </#if>

        <#if !sessionIsNull>
            <a href="/profile">
                <img src="user-profile-icon.jpg" style="height: 30px; width: 60px" />
            </a>
        </#if>
    </div>
    <div style="width: 100%; text-align: center;  font-weight: 500;
    font-family: Inter var, sans-serif; font-size: 32px; margin-top: 50px; --tw-text-opacity: 1;
    color: rgb(221 160 223 / var(--tw-text-opacity));
}">
        ✨Astrology✨
    </div>
    <div>

    </div>
</#macro>

</html>