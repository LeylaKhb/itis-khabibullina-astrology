<html lang="en">
<#include "base.ftl">

<#macro title>Regisatration page</#macro>

<#macro content>
    <div style="margin: 20px 50px">
        <a href="/" style="height: 30px; width: 60px">
            <button style="height: 30px; width: 60px; --tw-bg-opacity: 1;
    background-color: rgb(221 160 223  / var(--tw-bg-opacity)); border-radius: 6px; --tw-text-opacity: 1;
    color: rgb(255 255 255 / var(--tw-text-opacity)); font-size: 16px;">
                Back
            </button>
        </a>
    </div>

    <div style="display: flex; justify-content: center; margin-top: 150px">
        <form action="registration" method="post">
            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                Login:
                <input type="text" name="login" placeholder="login"/>
            </div>
            <br>

            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                Password:
                <input type="password" placeholder="password" name="password"/>
            </div>
            <br>

            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                Date of birth:
                <input type="date" name="dateOfBirth"/>
            </div>
            <br>

            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                Name:
                <input type="text" placeholder="name" name="name"/>
            </div>
            <br>

            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                City:
                <input type="text" placeholder="city" name="city"/>
            </div>

            <div style="font-weight: 500; margin-top: 10px;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                <input type="checkbox" name="remember">Remember me</input>
            </div>
            <br>


            <input type="submit" value="Registration" style="height: 30px; width: 120px; --tw-bg-opacity: 1;
        background-color: rgb(221 160 223  / var(--tw-bg-opacity)); border-radius: 6px; --tw-text-opacity: 1;
        color: rgb(255 255 255 / var(--tw-text-opacity)); font-size: 16px;" />
        </form>
    </div>

</#macro>

</html>