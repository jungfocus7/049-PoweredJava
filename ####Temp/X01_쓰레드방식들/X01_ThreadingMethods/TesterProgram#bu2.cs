using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;


namespace ConsoleApp6
{
    public static class TestHelper
    {
        public static void CommonWait(ref object fntrd)
        {
            Console.WriteLine("Press Esc key to exit...");
            while (true)
            {
                ConsoleKeyInfo cki = Console.ReadKey(true);
                if (cki.Key == ConsoleKey.Escape)
                {
                    Console.WriteLine("End program");
                    Thread.Sleep(1000);
                    break;
                }
                else if (cki.Key == ConsoleKey.Delete)
                {
                    Console.WriteLine("Terminates the worker thread");
                    fntrd = null;
                }
                else if (cki.Key == ConsoleKey.F)
                {
                    Process prc = Process.GetCurrentProcess();
                    int tc = prc.Threads.Count;
                    Console.WriteLine($"Current Thread Count: {tc}");
                }
            }
        }
    }


    #region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 01) ThreadPool.QueueUserWorkItem
    public static class ThreadTester01
    {
        private static volatile WaitCallback _fntrd;
        private static void ThreadFunction(object state)
        {
            while (_fntrd != null)
            {
                Thread.Sleep(1000);
                Console.WriteLine("ThreadFunction");
            }
        }
        public static void Test()
        {
            _fntrd = ThreadFunction;
            ThreadPool.QueueUserWorkItem(_fntrd, "null");

            Console.WriteLine("Press Esc key to exit...");
            while (true)
            {
                ConsoleKeyInfo cki = Console.ReadKey(true);
                if (cki.Key == ConsoleKey.Escape)
                {
                    Console.WriteLine("End program");
                    Thread.Sleep(1000);
                    break;
                }
                else if (cki.Key == ConsoleKey.Delete)
                {
                    Console.WriteLine("Terminates the worker thread");
                    _fntrd = null;
                }
                else if (cki.Key == ConsoleKey.F)
                {
                    Process prc = Process.GetCurrentProcess();
                    int tc = prc.Threads.Count;
                    Console.WriteLine($"Current Thread Count: {tc}");
                }
            }
        }
    }
    #endregion


    #region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 02) Action.BeginInvoke
    public static class ThreadTester02
    {
        private static volatile Action _fntrd;
        private static void ThreadFunction()
        {
            while (_fntrd != null)
            {
                Thread.Sleep(1000);
                Console.WriteLine("ThreadFunction");
            }
        }
        public static void Test()
        {
            _fntrd = ThreadFunction;
            _fntrd.BeginInvoke(null, null);

            Console.WriteLine("Press Esc key to exit...");
            while (true)
            {
                ConsoleKeyInfo cki = Console.ReadKey(true);
                if (cki.Key == ConsoleKey.Escape)
                {
                    Console.WriteLine("End program");
                    Thread.Sleep(1000);
                    break;
                }
                else if (cki.Key == ConsoleKey.Delete)
                {
                    Console.WriteLine("Terminates the worker thread");
                    _fntrd = null;
                }
            }
        }
    }
    #endregion


    #region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 03) Task.Run
    public static class ThreadTester03
    {
        private static volatile Action _fntrd;
        private static void ThreadFunction()
        {
            while (_fntrd != null)
            {
                Thread.Sleep(1000);
                Console.WriteLine("ThreadFunction");
            }
        }
        public static void Test()
        {
            _fntrd = ThreadFunction;
            Task.Run(_fntrd);

            Console.WriteLine("Press Esc key to exit...");
            while (true)
            {
                ConsoleKeyInfo cki = Console.ReadKey(true);
                if (cki.Key == ConsoleKey.Escape)
                {
                    Console.WriteLine("End program");
                    Thread.Sleep(1000);
                    break;
                }
                else if (cki.Key == ConsoleKey.Delete)
                {
                    Console.WriteLine("Terminates the worker thread");
                    _fntrd = null;
                }
            }
        }
    }
    #endregion



    public static class TesterProgram
    {
        public static void Main(string[] args)
        {
            ThreadTester01.Test();

            //ThreadTester02.Test();

            //ThreadTester03.Test();

        }

    }

}
