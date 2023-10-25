<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "base.ftl">

<#macro title>Forum</#macro>

<#macro content>

    <div class="ml-3 mt-3">
        <a href="/">
            <button class="text-white rounded-md bg-pink-400 font-medium h-10 w-20 text-ml text-center" >
                Back
            </button>
        </a>
    </div>

    <div class="text-pink-400 w-full flex items-center justify-center font-medium text-2xl mt-12 ">
        ✨Posts✨
        <br>
    </div>

    <#if sessionLogin??>
        <div class="flex justify-center items-center mt-20">
            <form action="forum" method="post" >
                <div class="font-medium text-pink-400 text-ml">
                    Share your opinion:
                    <br>
                    <textarea name="content" placeholder="I think..."  class="border border-pink-400 bg-pink-50
                rounded-md w-52 h-24"></textarea>
                </div>
                <input type="submit" value="Create post" class="text-white rounded-md bg-pink-400 font-medium h-12 w-24
            mx-20 my-14 text-ml text-center" />
            </form>
        </div>
    </#if>


    <div class="flex justify-center items-center flex-col">
        <#if posts?has_content>
            <#list posts as p>
                <div class="text-pink-400 w-1/2 font-medium
                mt-12 border border-pink-400 bg-pink-50">
                    <div class="text-pink-400 font-normal mx-3 border border-pink-400 bg-pink-50 text-xl">
                        Login: ${p.userLogin}
                        <#if sessionLogin??>
                            <#if p.userLogin == sessionLogin>
                                <br>
                                <a href="/editPost?id=${p.id}">
                                    <button class="text-white rounded-md bg-pink-400
                                        font-medium h-8 w-20 text-ml text-center">
                                        Edit
                                    </button>
                                </a>

                                <a href="/deletePost?id=${p.id}">
                                    <button class="text-white rounded-md bg-pink-400
                                        font-medium h-8 w-20 text-ml text-center">
                                        Delete
                                    </button>
                                </a>

                            </#if>
                        </#if>
                    </div>
                    <br>
                    <div class="text-ml mx-1">
                        Date: ${p.dateOfCreation}
                        <br>
                        ${p.content}
                    </div>

                    <div class="mx-9">
                        <#if comments?has_content>
                            <#list comments as c>
                                <#if c.postId == p.id>
                                    <div class="text-pink-400 font-normal border border-pink-400 bg-pink-50 text-sm">
                                        ${c.userLogin}: ${c.content}
                                        <#if sessionLogin??>
                                            <#if c.userLogin == sessionLogin>
                                                <br>
                                                <button class="text-white rounded-md bg-pink-400
                                        font-medium h-4 w-16 text-sm text-center">
                                                    Edit
                                                </button>
                                                <button class="text-white rounded-md bg-pink-400
                                        font-medium h-4 w-16 text-sm text-center">
                                                    Delete
                                                </button>
                                            </#if>
                                        </#if>
                                    </div>
                                </#if>
                            </#list>
                        </#if>

                        <#if sessionLogin??>
                            <form action="comment" method="post" >
                                <div class="font-medium text-pink-400 text-ml ">
                                    New comment:
                                    <br>
                                    <textarea name="commentContent" placeholder="I think..."  class="border border-pink-400 bg-pink-50
                            rounded-md w-28 h-10"></textarea>
                                    <br>
                                    <input type="text" hidden="hidden" name="postId" value=${p.id} />
                                    <input type="submit" value="Add comment" class="text-white rounded-md bg-pink-400
                                    font-medium h-8 w-32 text-ml text-center" />
                                </div>
                            </form>
                        </#if>
                    </div>
                </div>
            </#list>
        </#if>
        <#if !posts?has_content>
            <div class="text-pink-400 w-full flex items-center justify-center font-medium text-xl mt-12">
                No posts yet
            </div>
        </#if>
    </div>
</#macro>

</html>