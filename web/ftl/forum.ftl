<#import "base.ftl" as base/>
<#import "slideHeadMain.ftl" as slideHeadMain/>

<!DOCTYPE html>
<html lang="en">
<@base.head value="Chat"/>
<body>
<!--шапка-->
<@slideHeadMain.slideHead/>
<hr>


<script type="text/javascript">
    var where = null;
</script>
<div id="chat-container" style="height: 500px;">
    <div id="search-container">
        <form method="get">
            <input type="text" name="search" placeholder="Search" id="search"/>
        </form>
    </div>
    <!--last message from users-->
    <div id="conversation-list">
        <#if usersAndLastMessages1??>
            <#list usersAndLastMessages1 as userAndLastMessage>
                <form method="get">
                    <button input type="submit" value="${userAndLastMessage.user.id}" name="toUser">
                        <div class="conversation">
                            <!--в разработке<img src="../img/edkova.jpg" alt="Edkova Ksenia"/>-->
                            <div class="title-text">
                                ${userAndLastMessage.user.login}
                            </div>
                            <div class="created-dat">
                                <#if userAndLastMessage.message??>
                                    ${userAndLastMessage.message.date}
                                </#if>
                            </div>
                            <div class="conversation-message">
                                <#if userAndLastMessage.message??>
                                    ${lastMessageAndUser.message.text}
                                </#if>
                                <#if !userAndLastMessage.message??>
                                    Написать
                                </#if>

                            </div>
                        </div>
                    </button>
                    <input name="search" type="hidden" value="${login}"
                           id="search"/>
                </form>
            </#list>
        </#if>
    </div>


    <!--    Переписка с кем-то-->

    <div id="chat-title">
        <#if mainUser??>
            <span>${mainUser.login}</span>
        </#if>
    </div>


    <div id="chat-message-list">
        <#if messages??>
            <#list messages as message>
                <#if message.fromUserId == mainUser.id>
                    <div class="message-row you-message ">
                        <div class="message-content ">
                            <div class="message-text">${message.text}</div>
                            <div class="message-time">${message.date}</div>
                        </div>
                    </div>
                </#if>
                <#if message.fromUserId != mainUser.id>
                    <div class="message-row other-message">
                        <div class="message-content col-xs-4 col-sm-12 col-md-10 col-lg-4">
                            <!-- <img src="../img/edkova.jpg" alt="Edkova Ksenia"/>-->
                            <div class="message-text">${message.text}</div>
                            <div class="message-time">${message.date}</div>
                        </div>
                    </div>
                </#if>
            </#list>
        </#if>
    </div>

    <div id="chat-form">
        <form method="post">
            <input name="message" type="text" placeholder="Put your message"
                   id="message"/>
        </form>
    </div>

</div>
<hr><!--футер-->
<@base.end/>


</body>
</html>