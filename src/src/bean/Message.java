package bean;

public class Message
{
    private int messageId;
    private String content;
    private int senderId;
    private int roomId;

    // コンストラクタ
    public Message()
    {
    }

    // messageIdのゲッターとセッター
    public int getMessageId()
    {
        return messageId;
    }

    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
    }

    // contentのゲッターとセッター
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    // senderIdのゲッターとセッター
    public int getSenderId()
    {
        return senderId;
    }

    public void setSenderId(int senderId)
    {
        this.senderId = senderId;
    }

    // roomIdのゲッターとセッター
    public int getRoomId()
    {
        return roomId;
    }

    public void setRoomId(int roomId)
    {
        this.roomId = roomId;
    }
}
