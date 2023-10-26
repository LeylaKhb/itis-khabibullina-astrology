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
                <button class="text-white rounded-md bg-pink-400 font-medium h-10 w-20 text-ml text-center" >
                    Back
                </button>
            </a>
        </div>

    <div class="w-full items-center justify-between flex">
        <div class="w-1/3 flex items-center justify-center mt-32 flex-col">
            <form action="profile" method="post">
                <div class="text-xl text-pink-400 font-medium">
                    Edit profile:
                </div>
                <br>
                <div class="font-medium text-pink-400 text-ml">
                    Login:
                    <input type="text" value=${user.login} name="login" class="border border-pink-400
                bg-pink-50 rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-400 text-ml">
                    Password:
                    <input type="password" value=${user.password} placeholder="password" name="password" class="border
                border-pink-400 bg-pink-50 rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-400 text-ml">
                    Date of birth:
                    <input type="date" id="dateOfBirth" value=${dateOfBirth} name="dateOfBirth" class="border border-pink-400 bg-pink-50
                rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-400 text-ml">
                    Zodiac sign:
                    <input readonly type="text" id="zodiacSign" value=${user.zodiacSign} name="zodiacSign" class="border border-pink-400
                bg-pink-50 rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-400 text-ml">
                    Name:
                    <input type="text" value=${user.name} name="name" class="border border-pink-400
                bg-pink-50 rounded-md"/>
                </div>
                <br>

                <div class="font-medium text-pink-400 text-ml">
                    City:
                    <input id="city" type="text" placeholder="city" value=${user.city} name="city" class="border border-pink-400
                bg-pink-50 rounded-md"/>
                </div>

                <input id="editButton" type="submit" value="Edit" class="text-white rounded-md bg-pink-400 font-medium h-12 w-24 mx-20
            mt-3 text-ml text-center" />
                <br>

            </form>

            <div>
                <a href="/logout">
                    <button class="text-white rounded-md bg-pink-400 font-medium h-12 w-24 mx-20 mt-3 text-ml
                text-center">
                        Logout
                    </button>
                </a>
            </div>
        </div>

        <div class="w-1/3 items-center justify-between flex flex-col">
            <a href="/friends">
                <button class="text-white rounded-md bg-pink-400 font-medium h-12 w-24 mx-20 mt-3 text-ml
                text-center">
                    My friends
                </button>
            </a>
        </div>

        <div class="w-1/3 items-center justify-between flex flex-col">
            <#if imageUrl??>
                <img class="w-36 object-contain" src=${imageUrl} />
            </#if>
            <#if !imageUrl??>
                <img class="w-36 object-contain"
                     src="http://res.cloudinary.com/dphkmjgiy/image/upload/v1697199951/kdtdxbd7l1ujeshrhpun.jpg" />
            </#if>

            <a href="/upload">
                <button class="text-white rounded-md bg-pink-400 font-medium h-12 w-24 mx-20 mt-3 text-ml
                text-center">
                    Edit photo
                </button>
            </a>
        </div>
    </div>

</#macro>

</html>