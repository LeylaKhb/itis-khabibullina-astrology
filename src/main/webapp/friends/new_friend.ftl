<html lang="en">
<#include "../base.ftl">

<#macro title>New friend</#macro>

<script>
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
</script>

<#macro content>
    <div class="ml-3 mt-3">
        <a href="/friends">
            <button class="text-white rounded-md bg-pink-400 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>

    <div class="flex items-center justify-center mt-32 flex-col">
        <form action="addFriend" method="post">
            <div class="text-xl text-pink-400 font-medium">
                Add new friend:
            </div>
            <br>

            <div class="font-medium text-pink-400 text-ml">
                Name:
                <input type="text" name="name" class="border border-pink-400
            bg-pink-50 rounded-md"/>
            </div>
            <br>

            <div class="font-medium text-pink-400 text-ml">
                Date of birth:
                <input type="date" id="dateOfBirth" name="dateOfBirth" class="border border-pink-400 bg-pink-50
            rounded-md"/>
            </div>
            <br>

            <div class="font-medium text-pink-400 text-ml">
                Zodiac sign:
                <input readonly type="text" id="zodiacSign" name="zodiacSign" class="border border-pink-400
            bg-pink-50 rounded-md"/>
            </div>
            <br>

            <div class="font-medium text-pink-400 text-ml">
                City:
                <input id="city" type="text" placeholder="city" name="city" class="border border-pink-400
            bg-pink-50 rounded-md"/>
            </div>

            <input type="submit" value="Edit" class="text-white rounded-md bg-pink-400 font-medium h-12 w-24 mx-20
        mt-3 text-ml text-center" />
            <br>

        </form>
    </div>

</#macro>

</html>