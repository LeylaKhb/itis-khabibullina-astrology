<html lang="en">
<#include "base.ftl">

<#macro title>Profile</#macro>

<script>
    let editButton = document.getElementById("editButton");

    const dateOfBirthField = document.getElementById("dateOfBirth");
    const zodiacSign = document.getElementById("zodiacSign");
    dateOfBirthField.onchange = function(){
        let dateOfBirth = dateOfBirthField.value;
        let month = dateOfBirth.split("-")[1];
        let date = dateOfBirth.split("-")[2];
        if (month == 1) {
            if (date <= 20) zodiacSign.value = "Capricorn";
            else zodiacSign.value = "Aquarius";
        } if (month == 2) {
            if (date <= 19) zodiacSign.value = "Aquarius";
            else zodiacSign.value = "Pisces";
        } if (month == 3) {
            if (date <= 20) zodiacSign.value = "Pisces";
            else zodiacSign.value = "Aries";
        } if (month == 4) {
            if (date <= 20) zodiacSign.value = "Aries";
            else zodiacSign.value = "Taurus";
        } if (month == 5) {
            if (date <= 21) zodiacSign.value = "Taurus";
            else zodiacSign.value = "Gemini";
        } if (month == 6) {
            if (date <= 21) zodiacSign.value = "Gemini";
            else zodiacSign.value = "Cancer";
        } if (month == 7) {
            if (date <= 22) zodiacSign.value = "Cancer";
            else zodiacSign.value = "Leo";
        } if (month == 8) {
            if (date <= 21) zodiacSign.value = "Leo";
            else zodiacSign.value = "Virgo";
        } if (month == 9) {
            if (date <= 23) zodiacSign.value = "Virgo";
            else zodiacSign.value = "Libra";
        } if (month == 10) {
            if (date <= 23) zodiacSign.value = "Libra";
            else zodiacSign.value = "Scorpio";
        } if (month == 11) {
            if (date <= 22) zodiacSign.value = "Scorpio";
            else zodiacSign.value = "Sagittarius";
        } if (month == 12) {
            if (date <= 22) zodiacSign.value = "Sagittarius";
            else zodiacSign.value = "Capricorn";
        }
    };

    let editPasswordButton = document.getElementById("editPasswordButton")
    let passwordField = document.getElementById("password");
    let passwordCorrectField = document.getElementById("passwordCorrect");
    let passwordIncorrectField = document.getElementById("passwordIncorrect");
    passwordField.onchange = function() {
        let password = passwordField.value;
        if (password.match(/(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{8,}/g)) {
            passwordIncorrectField.hidden = true;
            passwordCorrectField.hidden = false;
            editPasswordButton.disabled = false;
        } else {
            passwordIncorrectField.hidden = false;
            passwordCorrectField.hidden = true;
            editPasswordButton.disabled = true;
        }
    }

    let cityField = document.getElementById("city");
    let cityIncorrectField = document.getElementById("cityIncorrect");
    cityField.onchange = function() {
        let city = cityField.value;
        if (city.match(/^([a-zA-Z]+-[a-zA-Z]+)$/g)) {
            cityIncorrectField.hidden = true;
            editButton.disabled = false;
        } else {
            cityIncorrectField.hidden = false;
            editButton.disabled = true;
        }
    }
</script>

<#macro content>
        <div class="ml-3 mt-3">
            <a href="/">
                <button class="text-white rounded-md bg-pink-600 font-medium h-10 w-20 text-ml text-center" >
                    Back
                </button>
            </a>
        </div>

    <div class="w-full items-center justify-between flex">
        <div class="w-1/4 flex items-center justify-center mt-32 flex-col">
            <form action="profile" method="post">
                <div class="text-xl text-pink-600 font-medium">
                    Edit profile:
                </div>
                <br>
                <div class="font-medium text-pink-600 text-ml">
                    Login: ${user.login}
                </div>
                <br>

                <div class="font-medium text-pink-600 text-ml">
                    Date of birth:
                    <input type="date" id="dateOfBirth" value=${dateOfBirth} name="dateOfBirth" class="border border-pink-600 bg-pink-50
                rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-600 text-ml">
                    Zodiac sign:
                    <input readonly type="text" id="zodiacSign" value=${user.zodiacSign} name="zodiacSign" class="border border-pink-600
                bg-pink-50 rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-600 text-ml">
                    Name:
                    <input type="text" value=${user.name} name="name" class="border border-pink-600
                bg-pink-50 rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-600 text-ml">
                    City:
                    <input id="city" type="text" placeholder="city" value=${user.city} name="city" class="border border-pink-600
                bg-pink-50 rounded-md"/>
                </div>
                <div hidden="hidden" id="cityIncorrect" class="text-red-400 text-xs">
                    City isn't correct
                </div>

                <input id="editButton" type="submit" value="Edit" class="text-white rounded-md bg-pink-600 font-medium h-12 w-24 mx-20
            mt-3 text-ml text-center" />
                <br>

            </form>

            <#if userExist??>
                <div class="text-pink-600 w-full flex items-center justify-center font-medium text-xl">
                    User with this login exist, please use another login
                </div>
            </#if>
        </div>

        <div class="w-1/4 items-center justify-between flex flex-col">
            <form action="editPassword" method="post">
                <div class="font-medium text-pink-600 text-ml">
                    Old password:
                    <input type="password" placeholder="password" name="oldPassword" class="border
                    border-pink-600 bg-pink-50 rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-600 text-ml">
                    New password:
                    <input id="password" type="password" placeholder="password" name="newPassword" class="border
                    border-pink-600 bg-pink-50 rounded-md"/>
                </div>

                <div id="passwordValidation" class="text-gray-600 text-xs">
                    Password should have minimum 8 characters and
                    <br>
                    contain at least one small letter, capital letter,
                    <br>
                    digit and special symbol from [!@#$%^&*]
                </div>
                <div hidden="hidden" id="passwordCorrect" class="text-green-400 text-xs">
                    Password is correct
                </div>
                <div hidden="hidden" id="passwordIncorrect" class="text-red-400 text-xs">
                    Password isn't correct
                </div>

                <input id="editPasswordButton" type="submit" value="Edit password" class="text-white rounded-md
                bg-pink-600 font-medium h-12 w-28 mx-20
                mt-3 text-ml text-center" />
                <br>
            </form>

            <#if wrongPassword?? >
                <div class="text-pink-600 w-full flex items-center justify-center font-medium text-xl">
                    Wrong password
                </div>
            </#if>

            <#if changedPassword?? >
                <div class="text-pink-600 w-full flex items-center justify-center font-medium text-xl">
                    Password was changed successfully
                </div>
            </#if>
        </div>

        <div class="w-1/4 items-center justify-between flex flex-col">
            <a href="/friends">
                <button class="text-white rounded-md bg-pink-600 font-medium h-12 w-24 mx-20 mt-3 text-ml
                text-center">
                    My friends
                </button>
            </a>

            <div>
                <a href="/logout">
                    <button class="text-white rounded-md bg-pink-600 font-medium h-12 w-24 mx-20 mt-3 text-ml
                text-center">
                        Logout
                    </button>
                </a>
            </div>
        </div>

        <div class="w-1/4 items-center justify-between flex flex-col">
            <#if imageUrl??>
                <img class="w-36 object-contain" src=${imageUrl} />
            </#if>
            <#if !imageUrl??>
                <img class="w-36 object-contain"
                     src="http://res.cloudinary.com/dphkmjgiy/image/upload/v1697199951/kdtdxbd7l1ujeshrhpun.jpg" />
            </#if>

            <a href="/upload">
                <button class="text-white rounded-md bg-pink-600 font-medium h-12 w-24 mx-20 mt-3 text-ml
                text-center">
                    Edit photo
                </button>
            </a>
        </div>
    </div>

</#macro>

</html>