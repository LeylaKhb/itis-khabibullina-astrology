<html lang="en">
<#include "base.ftl">

<#macro title>Profile</#macro>

<#macro content>

    <section>

    <div style="margin: 20px 50px">
        <a href="/" style="height: 30px; width: 60px">
            <button style="height: 30px; width: 60px; --tw-bg-opacity: 1;
    background-color: rgb(221 160 223  / var(--tw-bg-opacity)); border-radius: 6px; --tw-text-opacity: 1;
    color: rgb(255 255 255 / var(--tw-text-opacity)); font-size: 16px;">
                Back
            </button>
        </a>
    </div>


    <div style=" display: flex; justify-content: center; align-items: center; margin-top: 150px">
        <form action="profile" method="post">
            <div style="font-weight: 600;
        font-family: Inter var, sans-serif; font-size: 24px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                Edit profile:
            </div>
            <br>
            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                Password:
                <input type="password" value=${user.password} placeholder="password" name="password"/>
            </div>
            <br>

            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                Date of birth:
                <input type="date" value=${user.dateOfBirth} name="dateOfBirth"/>
            </div>
            <br>

            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                Name:
                <input type="text" placeholder="name" value=${user.name} name="name"/>
            </div>
            <br>

            <div style="font-weight: 500;
        font-family: Inter var, sans-serif; font-size: 16px; --tw-text-opacity: 1;
        color: rgb(221 160 223 / var(--tw-text-opacity));">
                City:
                <input type="text" placeholder="city" value=${user.city} name="city"/>
            </div>
            <br>

            <input type="submit" value="Edit" style="height: 30px; width: 120px; --tw-bg-opacity: 1;
        background-color: rgb(221 160 223  / var(--tw-bg-opacity)); border-radius: 6px; --tw-text-opacity: 1;
        color: rgb(255 255 255 / var(--tw-text-opacity)); font-size: 16px;" />
            <br>

        </form>

        <div style="margin-top: 10px;">
            <a href="/logout">
                <button style="height: 30px; width: 80px; --tw-bg-opacity: 1;
    background-color: rgb(221 160 223  / var(--tw-bg-opacity)); border-radius: 6px; --tw-text-opacity: 1;
    color: rgb(255 255 255 / var(--tw-text-opacity)); font-size: 16px;">
                    Logout
                </button>
            </a>
        </div>


    </div>
</#macro>

</html>