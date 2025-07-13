using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;


namespace ConsoleApp6
{
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
                ConsoleKeyInfo cki =  Console.ReadKey();
                if (cki.Key == ConsoleKey.Escape)
                {
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
                ConsoleKeyInfo cki = Console.ReadKey();
                if (cki.Key == ConsoleKey.Escape)
                {
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
                ConsoleKeyInfo cki = Console.ReadKey();
                if (cki.Key == ConsoleKey.Escape)
                {
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
            //ThreadTester01.Test();

            //ThreadTester02.Test();

            ThreadTester03.Test();

        }








        //#region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 01) ThreadPool.QueueUserWorkItem
        //private static volatile WaitCallback _fntrd;
        //private static void ThreadFunction(object state)
        //{
        //    while (_fntrd != null)
        //    {
        //        Thread.Sleep(1000);
        //        Console.WriteLine("ThreadFunction");
        //    }
        //}
        //public static void Main(string[] args)
        //{
        //    _fntrd = ThreadFunction;
        //    bool br = ThreadPool.QueueUserWorkItem(_fntrd, "null");

        //    Console.WriteLine("End of keydown...");
        //    while (Console.ReadKey().Key != ConsoleKey.Escape)
        //    {
        //    }
        //}
        //#endregion


        //#region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 02) Action.BeginInvoke
        //private static volatile Action _fntrd;
        //private static void ThreadFunction()
        //{
        //    while (_fntrd != null)
        //    {
        //        Thread.Sleep(1000);
        //        Console.WriteLine("ThreadFunction");
        //    }
        //}
        //public static void Main(string[] args)
        //{
        //    _fntrd = ThreadFunction;
        //    _fntrd.BeginInvoke(null, null);

        //    Console.WriteLine("End of keydown...");
        //    while (Console.ReadKey().Key != ConsoleKey.Escape)
        //    {
        //    }
        //} 
        //#endregion




        ////private volatile static float dddddddddddd = 666666;

        //private volatile static bool _bLoop = true;
        //public static void Main(string[] args)
        //{
        //    Task tsk = Task.Run(delegate ()
        //    {
        //        while (_bLoop)
        //        {
        //            Thread.Sleep(1000);
        //            Console.WriteLine("~~~~~~~~~~2");
        //        }
        //    });

        //    Thread trdRun = new Thread((ThreadStart)delegate {
        //        Console.WriteLine("~~~~~~~~~~3");
        //    });
        //    trdRun.Start();

        //    Action fntrd = delegate
        //    {
        //        Console.WriteLine("~~~~~~~~~~4");
        //    };
        //    fntrd.BeginInvoke(delegate {
        //        Console.WriteLine("~~~~~~~~~~6");
        //    }, null);
        //    Delegate

        //    while (true)
        //    {
        //        Thread.Sleep(100);
        //        Console.WriteLine(">>>>>>");
        //    }

        //    tsk.Wait();
        //}






        //// 델리게이트 정의 (메서드의 시그니처와 일치해야 함)
        //delegate int MyDelegate(string text, int num);

        //public static void Main(string[] args)
        //{
        //    Console.WriteLine("메인 스레드 시작...");

        //    // 델리게이트 인스턴스 생성
        //    MyDelegate myDelegate = new MyDelegate(DoWork);

        //    // 델리게이트를 비동기적으로 호출 (BeginInvoke)
        //    // BeginInvoke의 마지막 두 파라미터는 비동기 호출 시 추가 정보를 전달할 수 있습니다.
        //    // 첫 번째는 비동기 작업이 완료될 때 호출될 콜백 메서드 (AsyncCallback)
        //    // 두 번째는 비동기 작업과 관련된 상태 객체 (null 가능)
        //    IAsyncResult asyncResult = myDelegate.BeginInvoke("Hello", 123, null, null);

        //    // 메인 스레드에서 다른 작업 수행 가능
        //    for (int i = 0; i < 5; i++)
        //    {
        //        Console.WriteLine($"메인 스레드 작업 중... {i}");
        //        Thread.Sleep(100);
        //    }

        //    // 비동기 작업이 완료될 때까지 기다리고 결과 가져오기 (EndInvoke)
        //    // EndInvoke를 호출하지 않으면, 비동기 작업에서 발생한 예외를 catch할 수 없습니다.
        //    int result = myDelegate.EndInvoke(asyncResult);

        //    Console.WriteLine($"비동기 작업 완료. 결과: {result}");
        //    Console.WriteLine("메인 스레드 종료.");
        //}

        //// 델리게이트가 가리킬 메서드
        //public static int DoWork(string text, int num)
        //{
        //    Console.WriteLine($"비동기 작업 시작: {text}, {num}");
        //    Thread.Sleep(2000); // 2초 동안 작업 시뮬레이션
        //    Console.WriteLine("비동기 작업 종료.");
        //    return text.Length + num;
        //}
    }
}
