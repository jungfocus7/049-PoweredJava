using System;
using System.Collections;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Input;
using System.Windows.Media;




namespace ExpansiveListViewExample
{
    public sealed partial class ListViewEx99 : ListView
    {
        public ListViewEx99()
        {
            InitializeComponent();

            Loaded += ppLoaded;
        }

        private void ppLoaded(object sd, RoutedEventArgs tea)
        {
            Loaded -= ppLoaded;

            ItemsSource = CommonHelper.BaseInfos;
        }

        protected override void OnPreviewMouseRightButtonDown(MouseButtonEventArgs ea)
        {
            ea.Handled = true;

            base.OnPreviewMouseRightButtonDown(ea);
        }

        protected override DependencyObject GetContainerForItemOverride()
        {
            return new ListViewItemEx99();
        }


        //private int m_gi = 0;

        //public void PrevSelectedGotoView()
        //{
        //    IList lst = SelectedItems;
        //    if ((lst != null) && (lst.Count > 0))
        //    {
        //        int li = lst.Count;
        //        if (li > 0) --li;

        //        if (m_gi < 0) m_gi = 0;
        //        else if (m_gi > li) m_gi = li;

        //        object obj = lst[m_gi--];
        //        ScrollIntoView(obj);
        //    }
        //}

        //public void NextSelectedGotoView()
        //{
        //    IList lst = SelectedItems;
        //    if ((lst != null) && (lst.Count > 0))
        //    {
        //        int li = lst.Count;
        //        if (li > 0) --li;

        //        if (m_gi < 0) m_gi = 0;
        //        else if (m_gi > li) m_gi = li;

        //        object obj = lst[m_gi++];
        //        ScrollIntoView(obj);
        //    }
        //}

    }
}
