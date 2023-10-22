using System.Runtime.InteropServices;
using System.Reflection.Metadata;
// using System;
// using System.IO;

// namespace QueueImplementation
// {
//     public class FileQueue
//     {
//         private const string QUEUE_FILE_NAME = "queue.txt";
//         private string _filePath;
//         private StreamWriter _fileWriter;
//         private StreamReader _fileReader;
//         private string _currentLine;

//         public FileQueue()
//         {
//             _filePath = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.Desktop), QUEUE_FILE_NAME);
//             _fileWriter = new StreamWriter(_filePath);
//             _fileReader = new StreamReader(_filePath);
//         }

//         public void Enqueue(string data)
//         {
//             _fileWriter.WriteLine(data);
//             _fileWriter.Flush();
//         }

//         public string Dequeue()
//         {
//             _currentLine = _fileReader.ReadLine();
//             return _currentLine;
//         }

//         public void Seek(int index)
//         {
//             int filePosition = 0;
//             for (int i = 0; i < index; i++)
//             {
//                 filePosition += _currentLine.Length + 1;
//                 _fileReader.ReadLine();
//             }
//             _fileReader.DiscardBufferedData();
//             _fileReader.BaseStream.Seek(filePosition, SeekOrigin.Begin);
//             _currentLine = _fileReader.ReadLine();
//         }
//     }
// }

using System;
using System.IO;
using System.Collections.Generic;

public class FileBasedQueue
{
    private Queue<string> queue;
    private string filePath;

    public FileBasedQueue(string filePath)
    {
        this.filePath = filePath;
        this.queue = new Queue<string>(File.ReadAllLines(filePath));
    }

    public void Enqueue(string item)
    {
        queue.Enqueue(item);
        File.AppendAllText(filePath, item + Environment.NewLine);
    }

    public string Dequeue()
    {
        var item = queue.Dequeue();
        var allLines = File.ReadAllLines(filePath);
        File.WriteAllLines(filePath, allLines[1..]);
        return item;
    }

    public string Seek(int index)
    {
        if (index < 0 || index >= queue.Count)
        {
            throw new IndexOutOfRangeException();
        }

        return queue.ToArray()[index];
    }
    public static void main(string[] args){
        FileBasedQueue fileBasedQueue = new FileBasedQueue();
        fileBasedQueue.Enqueue("dfldlfd;");
        fileBasedQueue.Enqueue("dlkfjdlkdkfj");        
        fileBasedQueue.Enqueue("dlkfjdlkdkfj");        
        fileBasedQueue.Enqueue("dlkfjdlkdkfj");        
        fileBasedQueue.Enqueue("dlkfjdlkdkfj");        
        fileBasedQueue.Enqueue("dlkfjdlkdkfj");
        fileBasedQueue.Dequeue();
        
    }
}